package ltd.newbee.mall.task;

import com.google.common.collect.Maps;
import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.dao.NewBeeMallGoodsMapper;
import ltd.newbee.mall.dao.NewBeeMallOrderItemMapper;
import ltd.newbee.mall.dao.NewBeeMallOrderMapper;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.NewBeeMallOrder;
import ltd.newbee.mall.entity.NewBeeMallOrderItem;
import ltd.newbee.mall.redis.RedisCache;
import ltd.newbee.mall.util.HotGoodsScoreCalculateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class HotGoodsScheduleTask {
    @Autowired
    RedisCache redisCache;
    @Autowired
    NewBeeMallGoodsMapper goodsMapper;
    @Autowired
    NewBeeMallOrderMapper orderMapper;
    @Autowired
    NewBeeMallOrderItemMapper newBeeMallOrderItemMapper;
    @Scheduled(cron ="0 0 4 1 * ?")
    public void execute(){
        redisCache.deleteCacheZset(Constants.HOTGOODS);
        Map<Long,Long> goodsSellNum = Maps.newHashMap();
        Map<Long,Long> goodsClickNum = Maps.newHashMap();
        Set<ZSetOperations.TypedTuple<Long>> dataSet = new HashSet<>();
        List<NewBeeMallGoods> newBeeMallGoods = goodsMapper.selectALl();
        List<NewBeeMallOrder> newBeeMallOrders = orderMapper.selectAllSuccessOrder();
        List<Long> orderIds = newBeeMallOrders.stream().map(NewBeeMallOrder::getOrderId).collect(Collectors.toList());
        List<NewBeeMallOrderItem> newBeeMallOrderItems = newBeeMallOrderItemMapper.selectByOrderIds(orderIds);
        //获取所有已成功的商品Id和对应数量
        newBeeMallOrderItems.forEach(e->{
            Long num = goodsSellNum.get(e.getGoodsId());
            if(num == null){
                goodsSellNum.put(e.getGoodsId(),(long)e.getGoodsCount());
            }
            else{
                goodsSellNum.put(e.getGoodsId(), num + e.getGoodsCount());
            }
        });
        //获取所有的商品Id和对应点击数
        newBeeMallGoods.forEach(e-> {
            Long num = redisCache.getCacheObject(Constants.GOODS_CLICK+e.getGoodsId());
            if(num == null){
                num = 0L;
            }
            goodsClickNum.put(e.getGoodsId(),num);
        });
        goodsClickNum.forEach((goodsId, num) -> {
            long score = HotGoodsScoreCalculateUtil.allClickCalculate(num);
            if(goodsSellNum.get(goodsId) != null){
                score += HotGoodsScoreCalculateUtil.allSellCalculate(goodsSellNum.get(goodsId));
            }
            ZSetOperations.TypedTuple<Long> data = new DefaultTypedTuple<Long>(goodsId, (double) score);
            dataSet.add(data);
        });
        redisCache.redisTemplate.opsForZSet().add(Constants.HOTGOODS,dataSet);
    }
}
