/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.common;
public class Constants {

    public final static int INDEX_CAROUSEL_NUMBER = 5;//首页轮播图数量

    public final static int INDEX_CATEGORY_NUMBER = 10;//首页一级分类的最大数量

    public final static int SEARCH_CATEGORY_NUMBER = 8;//搜索页一级分类的最大数量

    public final static int INDEX_GOODS_HOT_NUMBER = 10;//首页热卖商品数量
    public final static int INDEX_GOODS_NEW_NUMBER = 5;//首页新品数量
    public final static int INDEX_GOODS_RECOMMOND_NUMBER = 10;//首页推荐商品数量

    public final static int SHOPPING_CART_ITEM_TOTAL_NUMBER = 13;//购物车中商品的最大数量

    public final static int SHOPPING_CART_ITEM_LIMIT_NUMBER = 5;//购物车中单个商品的最大购买数量

    public final static String MALL_VERIFY_CODE_KEY = "mallVerifyCode";//验证码key

    public final static String MALL_USER_SESSION_KEY = "newBeeMallUser";//session中user的key

    public final static int GOODS_SEARCH_PAGE_LIMIT = 10;//搜索分页的默认条数(每页10条)

    public final static int ORDER_SEARCH_PAGE_LIMIT = 3;//我的订单列表分页的默认条数(每页3条)

    public final static int SELL_STATUS_UP = 0;//商品上架状态
    public final static int SELL_STATUS_DOWN = 1;//商品下架状态

    public final static long ALL_SELLING_WEIGHT = 10000L;
    public final static long MONTH_SELLING_WEIGHT = 10000L;
    public final static long CLICK_WEIGHT = 100L;
    public final static String TOPIC_CUT_PRICE = "cut_price";

    public final static String CUT_PRICE_CONTENT = "您购物车中的物品降价了！去购买您心仪的商品吧！";
    /**
     * 字符编码
     */
    public static final String UTF_ENCODING = "UTF-8";

    /**
     * 秒杀下单盐值
     */
    public static final String SECKILL_ORDER_SALT = "asd";

    /**
     * 秒杀商品库存缓存
     */
    public static final String SECKILL_GOODS_STOCK_KEY = "seckill_goods_stock:";

    /**
     * 秒杀商品缓存
     */
    public static final String SECKILL_KEY = "seckill:";
    /**
     * 秒杀商品详情页面缓存
     */
    public static final String SECKILL_GOODS_DETAIL = "seckill_goods_detail:";
    /**
     * 秒杀商品列表页面缓存
     */
    public static final String SECKILL_GOODS_LIST = "seckill_goods_list";

    /**
     * 秒杀成功的用户set缓存
     */
    public static final String SECKILL_SUCCESS_USER_ID = "seckill_success_user_id:";
    /**
     * 将某件商品加入购物车的用户set
     */
    public static final String SHOP_CART_USER_ID = "shop_cart_user_id:";
    /**
     * 热点商品的缓存
     */
    public static final String HOTGOODS = "hot_goods";
    /**
     * 商品点击次数
     */
    public static final String GOODS_CLICK = "goods_click:";
    /**
     * 商品月销量
     */
    public static final String GOODS_MONTH_SELL = "goods_month_sell:";
}
