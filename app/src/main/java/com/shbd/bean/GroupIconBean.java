package com.shbd.bean;

import java.util.List;

/**
 * Created by yh on 2016/6/23.
 */
public class GroupIconBean {
    private DataBean data;

    private int retcode;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public static class DataBean {
        private String countcommenturl;
        private String more;
        private String title;

        private List<NewsBean> news;
        private List<?> topic;

        public String getCountcommenturl() {
            return countcommenturl;
        }

        public void setCountcommenturl(String countcommenturl) {
            this.countcommenturl = countcommenturl;
        }

        public String getMore() {
            return more;
        }

        public void setMore(String more) {
            this.more = more;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public List<?> getTopic() {
            return topic;
        }

        public void setTopic(List<?> topic) {
            this.topic = topic;
        }

        public static class NewsBean {
            private boolean comment;
            private String commentlist;
            private String commenturl;
            private int id;
            private String largeimage;
            private String listimage;
            private String pubdate;
            private String smallimage;
            private String title;
            private String type;
            private String url;

            public boolean isComment() {
                return comment;
            }

            public void setComment(boolean comment) {
                this.comment = comment;
            }

            public String getCommentlist() {
                return commentlist;
            }

            public void setCommentlist(String commentlist) {
                this.commentlist = commentlist;
            }

            public String getCommenturl() {
                return commenturl;
            }

            public void setCommenturl(String commenturl) {
                this.commenturl = commenturl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLargeimage() {
                return largeimage;
            }

            public void setLargeimage(String largeimage) {
                this.largeimage = largeimage;
            }

            public String getListimage() {
                return listimage;
            }

            public void setListimage(String listimage) {
                this.listimage = listimage;
            }

            public String getPubdate() {
                return pubdate;
            }

            public void setPubdate(String pubdate) {
                this.pubdate = pubdate;
            }

            public String getSmallimage() {
                return smallimage;
            }

            public void setSmallimage(String smallimage) {
                this.smallimage = smallimage;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "NewsBean{" +
                        "comment=" + comment +
                        ", commentlist='" + commentlist + '\'' +
                        ", commenturl='" + commenturl + '\'' +
                        ", id=" + id +
                        ", largeimage='" + largeimage + '\'' +
                        ", listimage='" + listimage + '\'' +
                        ", pubdate='" + pubdate + '\'' +
                        ", smallimage='" + smallimage + '\'' +
                        ", title='" + title + '\'' +
                        ", type='" + type + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "countcommenturl='" + countcommenturl + '\'' +
                    ", more='" + more + '\'' +
                    ", title='" + title + '\'' +
                    ", news=" + news +
                    ", topic=" + topic +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GroupIconBean{" +
                "data=" + data +
                ", retcode=" + retcode +
                '}';
    }
}
