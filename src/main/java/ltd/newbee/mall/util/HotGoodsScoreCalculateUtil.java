package ltd.newbee.mall.util;

import ltd.newbee.mall.common.Constants;

public class HotGoodsScoreCalculateUtil {
    static final private Long ALL_SELL_MAX_RANK = 5L;
    static final private Long ALL_SELL_RANK_NUM = 2000L;
    static final private Long ALL_SELL_RANK_PER_RANK_SCORE = 200L;
    static final private Long ALL_SELL_MAX_SCORE = 1000L;

    static final private Long CLICK_MAX_RANK = 5L;
    static final private Long CLICK_RANK_NUM = 200000L;
    static final private Long CLICK_RANK_PER_RANK_SCORE = 200L;
    static final private Long CLICK_MAX_SCORE = 1000L;

    static final private Long MONTH_SELL_MAX_RANK = 10L;
    static final private Long MONTH_SELL_RANK_NUM = 100L;
    static final private Long MONTH_SELL_RANK_PER_RANK_SCORE = 100L;
    static final private Long MONTH_SELL_MAX_SCORE = 1000L;

    //计算总销量分钟
    static public Long allSellCalculate(Long num){
        long rank = num / ALL_SELL_RANK_NUM;
        if(ALL_SELL_MAX_RANK > 5){
            return ALL_SELL_MAX_SCORE* Constants.ALL_SELLING_WEIGHT;
        }
        else{
            return rank * ALL_SELL_RANK_PER_RANK_SCORE * Constants.ALL_SELLING_WEIGHT;
        }
    }
    //计算总点击量分数
    static public Long allClickCalculate(Long num){
        long rank = num / CLICK_RANK_NUM;
        if(rank > CLICK_MAX_RANK){
            return CLICK_MAX_SCORE* Constants.CLICK_WEIGHT;
        }
        else{
            return rank * CLICK_RANK_PER_RANK_SCORE * Constants.CLICK_WEIGHT;
        }
    }

    //判断是否要变动月销量分数
    static public long checkMonth(Long before,Long now){
        if(before >= MONTH_SELL_MAX_SCORE){
            return 0;
        }
        return MONTH_SELL_RANK_PER_RANK_SCORE*(now/MONTH_SELL_RANK_NUM - before/MONTH_SELL_RANK_NUM);
    }
    //判断是否要变动总点击分数
    static public long checkClick(Long before,Long now){
        if(before >= CLICK_MAX_RANK * CLICK_RANK_NUM){
            return 0;
        }
        return CLICK_RANK_PER_RANK_SCORE*(now/CLICK_RANK_NUM - before/CLICK_RANK_NUM);
    }
}
