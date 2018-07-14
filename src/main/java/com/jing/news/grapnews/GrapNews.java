package com.jing.news.grapnews;

import com.jing.news.grapnews.domain.NewsBean;
import com.jing.news.grapnews.service.NewsService;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class GrapNews {

    private final Logger log = LoggerFactory.getLogger(GrapNews.class);

    @Autowired
    private NewsService service;


    public String getNews() {
        String idByString = "xinche";
        int categoryid = 5;
        try {
//            Lock lock = new ReentrantLock();
//            lock.lock();
//            lock.unlock();
            NodeFilter filter = new AndFilter(new TagNameFilter("div"), new HasAttributeFilter("id", idByString));
            Parser parser = new Parser();
            Parser bodyparser = new Parser();
            Parser titleparser = new Parser();
            parser.setURL("http://auto.qq.com/");// QQ 科技 > IT报道 > IT新闻
            parser.setEncoding(parser.getEncoding());

            NodeList list = parser.extractAllNodesThatMatch(filter);


            NewsBean newsBean = null;
            String textstr = list.elementAt(0).toHtml().trim();
            int i = 0;
            if (textstr.length() > 0) {
                int linkbegin = 0, linkend = 0, titlebegin = 0, titleend = 0;

                while (true) {
                    newsBean = new NewsBean();

                    titleend = textstr.indexOf("<h3>", titleend);
                    linkbegin = textstr.indexOf("href=", titleend);// 截取链接字符串起始位置

                    if (linkbegin < 0)
                        break;
                    //if (i > 70) break;
                    i++;
                    linkend = textstr.indexOf("\">", linkbegin);// 截取链接字符串结束位置
                    String sublink = "http://auto.qq.com" + textstr.substring(linkbegin + 6, linkend);

                    String link = sublink;
                    //	System.out.println(link);
                    titlebegin = textstr.indexOf("\">", linkend);
                    titleend = textstr.indexOf("</a>", titlebegin);
                    String title = textstr.substring(titlebegin + 2, titleend);
                    if (title.indexOf("<img") > 0) {
                        continue;

                    } else {
                        System.out.println("正在抓取 " + title);
                    }

                    try {

                        // 文章题目

//						NodeFilter filter3 = new AndFilter(new TagNameFilter("div"),
//								new HasAttributeFilter("class", "main"));
//						titleparser.setURL(link);
//						titleparser.setEncoding(titleparser.getEncoding());
//						NodeList list3 = titleparser.extractAllNodesThatMatch(filter3);
//						int titlebeg = 0, titleend2 = 0;
//						String textstr3 = "";
//						try {
//							textstr3 = list3.elementAt(0).toHtml().trim();
//						} catch (Exception e) {
//							continue;
//						}
//
//						titlebeg = textstr3.indexOf("<h1>", 0);
//						titleend2 = textstr3.indexOf("</h1>", titlebeg);
//						String title2 = textstr3.substring(titlebeg + 4, titleend2);
                        // System.out.println(title2);
                        newsBean.setTitle(title);
                        List<NewsBean> listNews = service.findNewsBycondition(newsBean);
                        int exist;
                        if (listNews == null) {
                            exist = 0;
                        } else {
                            exist = listNews.size();
                        }

                        if (exist == 1)
                            continue;
                        //	System.out.println("//文章题目");

                        // 文章时间
                        NodeFilter filter4 = new AndFilter(new TagNameFilter("span"),
                                new HasAttributeFilter("class", "a_time"));
                        titleparser.setURL(link);
                        titleparser.setEncoding(titleparser.getEncoding());
                        NodeList list4 = titleparser.extractAllNodesThatMatch(filter4);
                        int timebegin4 = 0, timeend4 = 0;
                        String textstr4 = "";
                        System.out.println("aa");
                        try {
                            textstr4 = list4.elementAt(0).toHtml().trim();
                        } catch (Exception e) {
                            continue;
                        }
                        //	System.out.println("bb");
                        timebegin4 = textstr4.indexOf(">", 0);

                        timeend4 = textstr4.indexOf("<", timebegin4);

                        String time4 = textstr4.substring(timebegin4 + 1, timeend4);

                        String mytime = time4.substring(0, 4) + "-" + time4.substring(5, 7) + "-"
                                + time4.substring(8, 10) + " " + time4.substring(11, 16) + ":00";

                        Timestamp ts = new Timestamp(System.currentTimeMillis());
                        ts = Timestamp.valueOf(mytime);
                        // System.out.println(ts.toString());
                        newsBean.setTime(ts);
                        //	System.out.println("文章时间");
                        // 文章摘要
                        // NodeFilter filter5 = new AndFilter(new
                        // TagNameFilter("p"), new HasAttributeFilter("class",
                        // "Introduction"));
                        // bodyparser.setURL(link);// QQ 科技 > IT报道 > IT新闻
                        // bodyparser.setEncoding(bodyparser.getEncoding());
                        // NodeList list5 =
                        // bodyparser.extractAllNodesThatMatch(filter5);
                        // int introbegin=0,introend=0;
                        // String textstr5="";
                        // try {
                        // textstr5 = list5.elementAt(0).toHtml()
                        // .trim();
                        // } catch (Exception e) {
                        // continue;
                        // }
                        // introbegin = textstr5.indexOf("]",0);
                        // introend=textstr5.indexOf("。", introbegin+1);
                        // String introduce5=textstr5.substring(introbegin+1,
                        // introend);
                        // // System.out.println(introduce5);
                        // newsBean.setKeywords(introduce5);
                        // 文章作者
                        NodeFilter filter6 = new AndFilter(new TagNameFilter("div"),
                                new HasAttributeFilter("id", "QQeditor"));
                        bodyparser.setURL(link);// QQ 科技 > IT报道 > IT新闻
                        bodyparser.setEncoding(bodyparser.getEncoding());
                        NodeList list6 = bodyparser.extractAllNodesThatMatch(filter6);
                        int authorbegin = 0, authorend = 0;
                        String textstr6 = "";
                        try {
                            textstr6 = list6.elementAt(0).toHtml().trim();
                        } catch (Exception e) {
                            continue;
                        }
                        authorbegin = textstr6.indexOf("：", 0);
                        authorend = textstr6.indexOf("</div>", authorbegin);
                        String author = textstr6.substring(authorbegin + 1, authorend);
                        // System.out.println(author);
                        newsBean.setAuthorName(author);
                        //		 System.out.println("文章作者");
                        // 文章内容

                        NodeFilter filter2 = new AndFilter(new TagNameFilter("div"),
                                new HasAttributeFilter("id", "Cnt-Main-Article-QQ"));
                        bodyparser.setURL(link);// QQ 科技 > IT报道 > IT新闻
                        bodyparser.setEncoding(bodyparser.getEncoding());
                        NodeList list2 = bodyparser.extractAllNodesThatMatch(filter2);
                        int conbegin = 0, conend = 0; // xuyao

                        String textstr2 = "";
                        try {
                            textstr2 = list2.elementAt(0).toHtml().trim();
                        } catch (Exception e) {
                            continue;
                        }
                        // System.out.println(textstr2);

                        conbegin = textstr2.indexOf("Cnt-Main-Article-QQ", 0);

                        conend = textstr2.indexOf("</div>", conbegin);

                        int conend2 = 0, conend3 = 0, conend4 = 0;
                        String content = "";
                        try {

                            conend2 = textstr2.indexOf("<!-- 相关视频 -->", conbegin);

                            content = content + textstr2.substring(conbegin - 9, conend2);

                        } catch (Exception e) {
                            content = textstr2.substring(conbegin - 9, conend + 6);
                        }
                        // System.out.println(content);
                        int picturebegin = 0, pictend = 0;
                        picturebegin = content.indexOf("src", 0);
                        if (picturebegin > 0) {
                            pictend = content.indexOf("\">", picturebegin);
                            String pictaddress = content.substring(picturebegin + 5, pictend);
                            newsBean.setPictureAddress(pictaddress);
                        } else {
                            newsBean.setPictureAddress("0");
                        }

                        newsBean.setContent(content);
                        newsBean.setCategoryId(categoryid);
                        newsBean.setVideoAddress("0");
                        service.addNews(newsBean);
                        log.info("成功抓取新闻：" + title );
                    } catch (Exception e) {
                        log.error(e.toString());
                    }

                }

            }

            return null;
        } catch (Exception e) {
            System.out.println("抓取信息出错，出错信息为：");
            e.printStackTrace();
            return "";
        }
    }
}
