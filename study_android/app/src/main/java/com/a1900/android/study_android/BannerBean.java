package com.a1900.android.study_android;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by 1900 on 2017/7/4.
 */

public class BannerBean extends BasePageBean<BannerBean.ResultBean.ItemsBean>{

    /**
     * code : 1
     * message : success
     * result : {"items":[{"detail":"","href":"https://www.oschina.net/news/86162/gitee-com-disclosed","id":86162,"img":"https://static.oschina.net/uploads/cooperation/75410/google-beta-natural-language-api_e811e340-79d8-4e75-be18-b6429eb6fe98.jpg","name":"码云独立域名正式揭晓","pubDate":"2017-06-26 14:08:22","type":6},{"detail":"","href":"https://www.oschina.net/event/2246165","id":2246165,"img":"https://static.oschina.net/uploads/cooperation/75323/ubuntu-forum-black-sql_f7f0589b-52af-4fa8-b928-fe2657bceec9.jpg","name":"源创会 | 济南站开始报名啦！","pubDate":"2017-06-26 17:08:23","type":5},{"detail":"","href":"https://www.oschina.net/question/2720166_2246947","id":2246947,"img":"https://static.oschina.net/uploads/cooperation/78083/chrome55-save-at-least-35-percent-memory_17e42ac9-9fb7-4f49-b8d3-50911fee310a.png","name":"深度学习核心算法与视觉实践","pubDate":"2017-07-04 18:07:59","type":2},{"detail":"","href":"https://www.oschina.net/news/86137/osc-help-local-developer-embarked-on-ai","id":86137,"img":"https://static.oschina.net/uploads/cooperation/77929/top-income-programming-languages-2016_0f75c8ff-3957-4f6c-96ec-b8c8e62ecddb.jpg","name":"开源中国帮开发者走上 AI 之路","pubDate":"2017-06-26 14:16:20","type":6},{"detail":"","href":"https://www.oschina.net/news/86128/what-i-need-to-do","id":86128,"img":"https://static.oschina.net/uploads/cooperation/78455/intellij-idea-2016-3-public-preview_eb19190e-57ff-4ad3-8028-95ab233caa8f.jpg","name":"当一个程序员写不出代码了","pubDate":"2017-06-26 14:18:41","type":6}],"nextPageToken":"61AF0C190D6BD629","prevPageToken":"3EA621243546C8A5","requestCount":5,"responseCount":5,"totalResults":5}
     * time : 2017-07-04 22:51:01
     */

    private int code;
    private String message;
    private ResultBean result;
    private String time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public List getItemDatas() {
        return result.items;
    }

    public static class ResultBean {
        /**
         * items : [{"detail":"","href":"https://www.oschina.net/news/86162/gitee-com-disclosed","id":86162,"img":"https://static.oschina.net/uploads/cooperation/75410/google-beta-natural-language-api_e811e340-79d8-4e75-be18-b6429eb6fe98.jpg","name":"码云独立域名正式揭晓","pubDate":"2017-06-26 14:08:22","type":6},{"detail":"","href":"https://www.oschina.net/event/2246165","id":2246165,"img":"https://static.oschina.net/uploads/cooperation/75323/ubuntu-forum-black-sql_f7f0589b-52af-4fa8-b928-fe2657bceec9.jpg","name":"源创会 | 济南站开始报名啦！","pubDate":"2017-06-26 17:08:23","type":5},{"detail":"","href":"https://www.oschina.net/question/2720166_2246947","id":2246947,"img":"https://static.oschina.net/uploads/cooperation/78083/chrome55-save-at-least-35-percent-memory_17e42ac9-9fb7-4f49-b8d3-50911fee310a.png","name":"深度学习核心算法与视觉实践","pubDate":"2017-07-04 18:07:59","type":2},{"detail":"","href":"https://www.oschina.net/news/86137/osc-help-local-developer-embarked-on-ai","id":86137,"img":"https://static.oschina.net/uploads/cooperation/77929/top-income-programming-languages-2016_0f75c8ff-3957-4f6c-96ec-b8c8e62ecddb.jpg","name":"开源中国帮开发者走上 AI 之路","pubDate":"2017-06-26 14:16:20","type":6},{"detail":"","href":"https://www.oschina.net/news/86128/what-i-need-to-do","id":86128,"img":"https://static.oschina.net/uploads/cooperation/78455/intellij-idea-2016-3-public-preview_eb19190e-57ff-4ad3-8028-95ab233caa8f.jpg","name":"当一个程序员写不出代码了","pubDate":"2017-06-26 14:18:41","type":6}]
         * nextPageToken : 61AF0C190D6BD629
         * prevPageToken : 3EA621243546C8A5
         * requestCount : 5
         * responseCount : 5
         * totalResults : 5
         */

        private String nextPageToken;
        private String prevPageToken;
        private int requestCount;
        private int responseCount;
        private int totalResults;
        private List<ItemsBean> items;

        public String getNextPageToken() {
            return nextPageToken;
        }

        public void setNextPageToken(String nextPageToken) {
            this.nextPageToken = nextPageToken;
        }

        public String getPrevPageToken() {
            return prevPageToken;
        }

        public void setPrevPageToken(String prevPageToken) {
            this.prevPageToken = prevPageToken;
        }

        public int getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(int requestCount) {
            this.requestCount = requestCount;
        }

        public int getResponseCount() {
            return responseCount;
        }

        public void setResponseCount(int responseCount) {
            this.responseCount = responseCount;
        }

        public int getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * detail :
             * href : https://www.oschina.net/news/86162/gitee-com-disclosed
             * id : 86162
             * img : https://static.oschina.net/uploads/cooperation/75410/google-beta-natural-language-api_e811e340-79d8-4e75-be18-b6429eb6fe98.jpg
             * name : 码云独立域名正式揭晓
             * pubDate : 2017-06-26 14:08:22
             * type : 6
             */

            private String detail;
            private String href;
            private int id;
            private String img;
            private String name;
            private String pubDate;
            private int type;

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
