package com.yui.system.library.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yui.system.library.entity.BookEntity;

/**
 * 获取图书信息工具类
 *
 * @author XuZhuohao
 * @date 2018-08-29 22:47
 */
public class BookInfoUtil {

    /**
     * {
     * 	"rating": {
     * 		"max": 10,
     * 		"numRaters": 26,
     * 		"average": "7.3",
     * 		"min": 0
     *        },
     * 	"subtitle": "",
     * 	"author": ["[美] F.S.菲兹杰拉德"],
     * 	"pubdate": "2018-1",
     * 	"tags": [{
     * 		"count": 3,
     * 		"name": "小说",
     * 		"title": "小说"
     *    }, {
     * 		"count": 2,
     * 		"name": "文学",
     * 		"title": "文学"
     *    }, {
     * 		"count": 2,
     * 		"name": "想读",
     * 		"title": "想读"
     *    }, {
     * 		"count": 1,
     * 		"name": "青春",
     * 		"title": "青春"
     *    }, {
     * 		"count": 1,
     * 		"name": "翻译界的灾难",
     * 		"title": "翻译界的灾难"
     *    }, {
     * 		"count": 1,
     * 		"name": "美国",
     * 		"title": "美国"
     *    }, {
     * 		"count": 1,
     * 		"name": "感受",
     * 		"title": "感受"
     *    }, {
     * 		"count": 1,
     * 		"name": "思考",
     * 		"title": "思考"
     *    }],
     * 	"origin_title": "",
     * 	"image": "https://img1.doubanio.com\/view\/subject\/m\/public\/s29748777.jpg",
     * 	"binding": "平装",
     * 	"translator": ["张炽恒"],
     * 	"catalog": "译 序\n了不起的盖茨比\n像里茨饭店一样大的钻石",
     * 	"pages": "",
     * 	"images": {
     * 		"small": "https://img1.doubanio.com\/view\/subject\/s\/public\/s29748777.jpg",
     * 		"large": "https://img1.doubanio.com\/view\/subject\/l\/public\/s29748777.jpg",
     * 		"medium": "https://img1.doubanio.com\/view\/subject\/m\/public\/s29748777.jpg"
     *    },
     * 	"alt": "https:\/\/book.douban.com\/subject\/30203179\/",
     * 	"id": "30203179",
     * 	"publisher": "时代文艺出版社",
     * 	"isbn10": "753875637X",
     * 	"isbn13": "9787538756371",
     * 	"title": "了不起的盖茨比",
     * 	"url": "https:\/\/api.douban.com\/v2\/book\/30203179",
     * 	"alt_title": "",
     * 	"author_intro": "F.S.菲茨杰拉德（1896－1940），20世纪美国杰出作家。1920年凭借长篇小说《人间天堂》一举成名。1925年出版的小说《了不起的盖茨比》，奠定了他在美国现代文学史上的地位。\n他用富有诗意的语言，全面、生动地描绘出美国20世纪20年代的社会生活，并将这段时期命名为“爵士时代”。他也因此被称为“爵士时代”的发言人和“桂冠诗人”。",
     * 	"summary": "纽约长岛的一座豪华公馆内经常笙歌达旦。这是主人盖茨比精心安排的盛宴，为了一位不曾到来的宾客——他的心上人戴茜。五年前，并不富裕的军官盖茨比与富家千金戴茜相爱了，金子般熠熠生辉的戴茜令他迷醉。但当他从战场归来时，戴茜已经嫁入富贵人家。\n为了挽回爱情，盖茨比努力奋斗，不惜贩卖私酒赚钱。他买下那座豪华公馆，因为戴茜就住在海湾对面；他举办盛宴，只盼戴茜能有一天逛到他的公馆来。他沉浸在与戴茜重逢的梦中，没想到他的梦带有巨大的创造力，甚至已经超越了戴茜，超越了一切。他终于与戴茜重逢，却并没有触碰到梦中的爱情……\n本书还收录了《一颗像里茨饭店一样大的钻石》，这是一篇关于财富的魔幻小说。主人公约翰受邀到同学珀西家做客，发现那竟是一座建在钻石山上与世隔绝的豪华宫殿。约翰享受了梦幻般的富足生活，却偶然得知从来没有外人活着离开过这里……\n两篇小说相辅相成，引发了人们关梦想、财富、爱情的思考。",
     * 	"price": "26"
     * }
     * @param url url
     * @param barCode barCode
     * @return result
     */
    public static String getBookInfoFromDouban(String url, Long barCode){
        HttpUtil httpClient = new HttpUtil();
        httpClient.doGet( url + ":" + barCode, null, null);
        return httpClient.getResult();
    }

    /**
     *
     * @param url url
     * @param barCode code
     * @return BookEntity
     */
    public static BookEntity getBookEntityFromDouban(String url, Long barCode){
        JSONObject resultJson = JSON.parseObject(getBookInfoFromDouban(url, barCode));
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTranslator(resultJson.getString("translator"));
        bookEntity.setName(resultJson.getString("title"));
        bookEntity.setIntro(resultJson.getString("summary"));
        bookEntity.setAuthor(resultJson.getString("author"));
        bookEntity.setBarcode(barCode);
        bookEntity.setIsbn10(resultJson.getString("isbn10"));
        bookEntity.setIsbn13(resultJson.getString("isbn13"));
        bookEntity.setPublisher(resultJson.getString("publisher"));
        return bookEntity;
    }
}
