package com.a1900.android.study_android;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by 1900 on 2017/7/4.
 */

public class NewsBean extends BasePageBean<NewsBean.ResultBean.ItemsBean> {


    /**
     * code : 1
     * message : success
     * result : {"items":[{"author":"王练","body":"Web 前端框架 Angular.js 1.6.5 发布了，更新内容如下： 新功能 select: 公开控制器中的选择状态信息 $animate: 添加对 customFilter 的支持 $c...","commentCount":14,"href":"https://www.oschina.net/news/86439/angularjs-1-6-5","id":86439,"pubDate":"2017-07-04 10:30:20","recommend":true,"title":"Angular.js 1.6.5 发布，Web 前端框架","type":6,"viewCount":793},{"author":"lylmwt","body":"大家好，然之协同管理软件4.3.beta版本于正式发布了！本版本主要升级框架，增强程序安全，升级一键安装包。 然之协同办公系统是一款面向中小企业内...","commentCount":1,"href":"https://www.oschina.net/news/86437/ranzhi-4-3-beta","id":86437,"pubDate":"2017-07-04 09:31:18","recommend":true,"title":"然之协同 4.3.beta 版本发布，升级框架增强程序安全","type":6,"viewCount":332},{"author":"达尔文","body":"开奖啦~开源社区翻译贡献计划 2017 年 5-6 月翻译贡献会员 TOP10 出炉。同时 7-8 月翻译贡献奖励计划火热进行中，欢迎大家踊跃参与。 5-6 月 10 名...","commentCount":3,"href":"https://www.oschina.net/news/86436/translate-5-and-6","id":86436,"pubDate":"2017-07-04 08:07:46","recommend":true,"title":"开源中国翻译频道贡献 2017 (5-6月) 奖励名单","type":6,"viewCount":817},{"author":"局长","body":"最近漏洞新闻层出不穷，作为一名技术人员，我们在注意自身文件安全的同时更要学会如何防护漏洞，本文将介绍 10 款开源的漏洞检测工具，以供开发者们...","commentCount":6,"href":"https://my.oschina.net/editorial-story/blog/1142966","id":1142966,"pubDate":"2017-07-04 08:01:12","recommend":true,"title":"工具推荐 | 漏洞层出不穷 试试这些开源漏洞检测工具","type":3,"viewCount":1806},{"author":"局长","body":"RePlugin 是奇虎 360 正在开源的一套完整的、稳定的、适合全面使用的，占坑类插件化方案。","commentCount":0,"href":"https://git.oschina.net/replugin/RePlugin","id":86434,"pubDate":"2017-07-04 08:00:32","recommend":true,"title":"码云推荐 | 灵活稳定的插件化方案 RePlugin","type":0,"viewCount":5},{"author":"局长","body":"在满足世界各地用户需求的开源项目中，本地化扮演着极其重要的角色。除了编码之外，语言翻译也是世界各地的人们从事开源事业并向开源项目做出贡献的...","commentCount":1,"href":"https://www.oschina.net/translate/open-source-localization-tools","id":10003905,"pubDate":"2017-07-04 07:59:56","recommend":false,"title":"协作翻译 | 18 个开源翻译工具帮助你的项目本地化","type":4,"viewCount":1089},{"author":"局长","body":"在日常开发中，线程常常被用作为提升程序效率的重要手段。这篇文章介绍了线程的基本运作。","commentCount":7,"href":"https://my.oschina.net/coorchice/blog/1142989","id":1142989,"pubDate":"2017-07-04 07:59:00","recommend":false,"title":"每日一博 | 关于线程，还有这些是你需要知道的！","type":3,"viewCount":1692},{"author":"局长","body":"Pencil Project 是一个用于制作图表和 GUI 原型的开源工具，旨在让每个人都可以免费使用。","commentCount":5,"href":"https://www.oschina.net/p/pencil-project","id":45568,"pubDate":"2017-07-04 07:58:06","recommend":false,"title":"Pencil Project \u2014\u2014 图表和 GUI 原型制作工具","type":1,"viewCount":1664},{"author":"局长","body":"Android O 开发者预览项目官方页面最近更新中，披露了关于即将到来的 Android 8.0 移动操作系统的更多细节。Android 8.0 系统的开发已经于今年春季...","commentCount":8,"href":"https://www.oschina.net/news/86430/android-8-schedule","id":86430,"pubDate":"2017-07-04 07:55:28","recommend":false,"title":"Android O 计划概览：最终版第三季度发布或名\u201cOreo\u201d","type":6,"viewCount":1099},{"author":"局长","body":"此前，我们曾报道过 GitLab 宣布收购开发者社交平台 Gitter 并计划开源的新闻。今天，我们看到 Gitter 的源码已静悄悄地出现在了 GitLab 的代码仓库...","commentCount":5,"href":"https://www.oschina.net/news/86429/gitter-is-open-source","id":86429,"pubDate":"2017-07-04 07:42:57","recommend":false,"title":"被 GitLab 收购的开发者社交平台 Gitter 已正式开源","type":6,"viewCount":1884},{"author":"局长","body":"身体是革命的本钱，有了好身体，才能写出优秀的代码。健身吧，程序员。","commentCount":41,"href":"https://my.oschina.net/xxiaobian/blog/1143196","id":1143196,"pubDate":"2017-07-04 07:33:18","recommend":false,"title":"OSChina 周二乱弹 \u2014 我看着手中半自动坐标采集器，陷入沉思","type":3,"viewCount":2748},{"author":"王练","body":"Apache Tomcat 8.0.45 和 7.0.79 发布了。 Apache Tomcat 8.0.45 的更新包括针对 8.0.44 中标识的问题的修复以及其他增强和更改。自 8.0.44 以来的...","commentCount":1,"href":"https://www.oschina.net/news/86427/apache-tomcat-8-0-45-and-7-0-79","id":86427,"pubDate":"2017-07-04 07:32:08","recommend":false,"title":"Apache Tomcat 8.0.45 和 7.0.79 发布","type":6,"viewCount":1154},{"author":"局长","body":"Ubuntu 在 MOTD 终端插入了一则消息，标题是\u201cHow HBO's Silicon Valley built 'Not Hotdog' with mobile TensorFlow, Keras & React Native.\u201d 它...","commentCount":11,"href":"https://www.oschina.net/news/86426/ubuntu-disputes-ads-in-motd-claims","id":86426,"pubDate":"2017-07-04 07:29:33","recommend":false,"title":"Ubuntu 被指向用户展示广告，产品经理否认","type":6,"viewCount":1343},{"author":"局长","body":"OneDrive 用户一夜之间发现微软这个云存储服务要求用户使用 NTFS 文件格式，否则 OneDrive 连接到的用户目录无法进行手动或者自动备份。 现在愤怒的...","commentCount":14,"href":"https://www.oschina.net/news/86425/onedrive-blocks-all-non-ntfs-locations","id":86425,"pubDate":"2017-07-04 07:27:35","recommend":false,"title":"激起众怒 OneDrive 突然要求用户使用 NTFS 格式","type":6,"viewCount":1387},{"author":"王练","body":"Countly 17.05.1 已发布，该版本新增了以下功能： 在 Analytics -> Browsers 中显示浏览器版本 Report Manager: 使报告阈值（切换到报表管理器之前...","commentCount":0,"href":"https://www.oschina.net/news/86424/countly-17-05-1","id":86424,"pubDate":"2017-07-04 07:22:57","recommend":false,"title":"Countly 17.05.1 发布，实时移动和 web 分析报告平台","type":6,"viewCount":747},{"author":"王练","body":"Fotoxx 17.04.3 已发布，Fotoxx 是一个 Linux 下的开源图形编辑器，它为用户提供了强大的工具来处理使用数码相机制作的图像文件。 Fotoxx 功能强大...","commentCount":2,"href":"https://www.oschina.net/news/86423/fotoxx-17-04-3","id":86423,"pubDate":"2017-07-04 07:22:22","recommend":false,"title":"Fotoxx 17.04.3 发布，功能强大的图片处理软件","type":6,"viewCount":813},{"author":"王练","body":"Lakka 2.1 RC3 已发布，Lakka 是一款轻量级的 Linux 发行版，将小型计算机转变为完整的游戏机。 更新内容： Citra 的 3DS 仿真器可用于 PC 64 位 ...","commentCount":5,"href":"https://www.oschina.net/news/86422/lakka-2-1-rc3","id":86422,"pubDate":"2017-07-04 07:20:25","recommend":false,"title":"Lakka 2.1 RC3 发布，游戏机用的 Linux 发行版","type":6,"viewCount":740},{"author":"王练","body":"Wagtail 1.11 已发布，Wagtail 是一个用 Python 编写的开源 CMS，基于 Django 框架构建。 它优雅、强大、敏捷，专注于灵活性和用户体验，为开发人...","commentCount":0,"href":"https://www.oschina.net/news/86421/wagtail-1-11","id":86421,"pubDate":"2017-07-04 07:19:42","recommend":false,"title":"Wagtail 1.11 发布，基于 Django 的内容管理系统","type":6,"viewCount":601},{"author":"王练","body":"Deployer 5.1.3 已发布，这是一个针对 5.1.2 （此版本修复了并行部署的几个错误，并改进了config：current 和 Symfony recipes ）的修复版本，修复...","commentCount":2,"href":"https://www.oschina.net/news/86420/deployer-5-1-3","id":86420,"pubDate":"2017-07-04 07:18:57","recommend":false,"title":"Deployer 5.1.3 发布，PHP 编写应用部署工具","type":6,"viewCount":623},{"author":"王练","body":"Rockstor 3.9.1 已发布，包含 30 多项更新，主要是一些主要功能更新和 bug 修复。其中，使用 LUKS 磁盘加密是该版本最大的亮点，也是社区一直想要的...","commentCount":0,"href":"https://www.oschina.net/news/86419/rockstor-3-9-1","id":86419,"pubDate":"2017-07-04 07:18:03","recommend":false,"title":"Rockstor 3.9.1 发布，开源 NAS 网络存储系统解决方案","type":6,"viewCount":666}],"nextPageToken":"DBA816934CD0AA59","prevPageToken":"0997C855C600E421","requestCount":20,"responseCount":20,"totalResults":79442}
     * time : 2017-07-04 16:08:06
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
         * items : [{"author":"王练","body":"Web 前端框架 Angular.js 1.6.5 发布了，更新内容如下： 新功能 select: 公开控制器中的选择状态信息 $animate: 添加对 customFilter 的支持 $c...","commentCount":14,"href":"https://www.oschina.net/news/86439/angularjs-1-6-5","id":86439,"pubDate":"2017-07-04 10:30:20","recommend":true,"title":"Angular.js 1.6.5 发布，Web 前端框架","type":6,"viewCount":793},{"author":"lylmwt","body":"大家好，然之协同管理软件4.3.beta版本于正式发布了！本版本主要升级框架，增强程序安全，升级一键安装包。 然之协同办公系统是一款面向中小企业内...","commentCount":1,"href":"https://www.oschina.net/news/86437/ranzhi-4-3-beta","id":86437,"pubDate":"2017-07-04 09:31:18","recommend":true,"title":"然之协同 4.3.beta 版本发布，升级框架增强程序安全","type":6,"viewCount":332},{"author":"达尔文","body":"开奖啦~开源社区翻译贡献计划 2017 年 5-6 月翻译贡献会员 TOP10 出炉。同时 7-8 月翻译贡献奖励计划火热进行中，欢迎大家踊跃参与。 5-6 月 10 名...","commentCount":3,"href":"https://www.oschina.net/news/86436/translate-5-and-6","id":86436,"pubDate":"2017-07-04 08:07:46","recommend":true,"title":"开源中国翻译频道贡献 2017 (5-6月) 奖励名单","type":6,"viewCount":817},{"author":"局长","body":"最近漏洞新闻层出不穷，作为一名技术人员，我们在注意自身文件安全的同时更要学会如何防护漏洞，本文将介绍 10 款开源的漏洞检测工具，以供开发者们...","commentCount":6,"href":"https://my.oschina.net/editorial-story/blog/1142966","id":1142966,"pubDate":"2017-07-04 08:01:12","recommend":true,"title":"工具推荐 | 漏洞层出不穷 试试这些开源漏洞检测工具","type":3,"viewCount":1806},{"author":"局长","body":"RePlugin 是奇虎 360 正在开源的一套完整的、稳定的、适合全面使用的，占坑类插件化方案。","commentCount":0,"href":"https://git.oschina.net/replugin/RePlugin","id":86434,"pubDate":"2017-07-04 08:00:32","recommend":true,"title":"码云推荐 | 灵活稳定的插件化方案 RePlugin","type":0,"viewCount":5},{"author":"局长","body":"在满足世界各地用户需求的开源项目中，本地化扮演着极其重要的角色。除了编码之外，语言翻译也是世界各地的人们从事开源事业并向开源项目做出贡献的...","commentCount":1,"href":"https://www.oschina.net/translate/open-source-localization-tools","id":10003905,"pubDate":"2017-07-04 07:59:56","recommend":false,"title":"协作翻译 | 18 个开源翻译工具帮助你的项目本地化","type":4,"viewCount":1089},{"author":"局长","body":"在日常开发中，线程常常被用作为提升程序效率的重要手段。这篇文章介绍了线程的基本运作。","commentCount":7,"href":"https://my.oschina.net/coorchice/blog/1142989","id":1142989,"pubDate":"2017-07-04 07:59:00","recommend":false,"title":"每日一博 | 关于线程，还有这些是你需要知道的！","type":3,"viewCount":1692},{"author":"局长","body":"Pencil Project 是一个用于制作图表和 GUI 原型的开源工具，旨在让每个人都可以免费使用。","commentCount":5,"href":"https://www.oschina.net/p/pencil-project","id":45568,"pubDate":"2017-07-04 07:58:06","recommend":false,"title":"Pencil Project \u2014\u2014 图表和 GUI 原型制作工具","type":1,"viewCount":1664},{"author":"局长","body":"Android O 开发者预览项目官方页面最近更新中，披露了关于即将到来的 Android 8.0 移动操作系统的更多细节。Android 8.0 系统的开发已经于今年春季...","commentCount":8,"href":"https://www.oschina.net/news/86430/android-8-schedule","id":86430,"pubDate":"2017-07-04 07:55:28","recommend":false,"title":"Android O 计划概览：最终版第三季度发布或名\u201cOreo\u201d","type":6,"viewCount":1099},{"author":"局长","body":"此前，我们曾报道过 GitLab 宣布收购开发者社交平台 Gitter 并计划开源的新闻。今天，我们看到 Gitter 的源码已静悄悄地出现在了 GitLab 的代码仓库...","commentCount":5,"href":"https://www.oschina.net/news/86429/gitter-is-open-source","id":86429,"pubDate":"2017-07-04 07:42:57","recommend":false,"title":"被 GitLab 收购的开发者社交平台 Gitter 已正式开源","type":6,"viewCount":1884},{"author":"局长","body":"身体是革命的本钱，有了好身体，才能写出优秀的代码。健身吧，程序员。","commentCount":41,"href":"https://my.oschina.net/xxiaobian/blog/1143196","id":1143196,"pubDate":"2017-07-04 07:33:18","recommend":false,"title":"OSChina 周二乱弹 \u2014 我看着手中半自动坐标采集器，陷入沉思","type":3,"viewCount":2748},{"author":"王练","body":"Apache Tomcat 8.0.45 和 7.0.79 发布了。 Apache Tomcat 8.0.45 的更新包括针对 8.0.44 中标识的问题的修复以及其他增强和更改。自 8.0.44 以来的...","commentCount":1,"href":"https://www.oschina.net/news/86427/apache-tomcat-8-0-45-and-7-0-79","id":86427,"pubDate":"2017-07-04 07:32:08","recommend":false,"title":"Apache Tomcat 8.0.45 和 7.0.79 发布","type":6,"viewCount":1154},{"author":"局长","body":"Ubuntu 在 MOTD 终端插入了一则消息，标题是\u201cHow HBO's Silicon Valley built 'Not Hotdog' with mobile TensorFlow, Keras & React Native.\u201d 它...","commentCount":11,"href":"https://www.oschina.net/news/86426/ubuntu-disputes-ads-in-motd-claims","id":86426,"pubDate":"2017-07-04 07:29:33","recommend":false,"title":"Ubuntu 被指向用户展示广告，产品经理否认","type":6,"viewCount":1343},{"author":"局长","body":"OneDrive 用户一夜之间发现微软这个云存储服务要求用户使用 NTFS 文件格式，否则 OneDrive 连接到的用户目录无法进行手动或者自动备份。 现在愤怒的...","commentCount":14,"href":"https://www.oschina.net/news/86425/onedrive-blocks-all-non-ntfs-locations","id":86425,"pubDate":"2017-07-04 07:27:35","recommend":false,"title":"激起众怒 OneDrive 突然要求用户使用 NTFS 格式","type":6,"viewCount":1387},{"author":"王练","body":"Countly 17.05.1 已发布，该版本新增了以下功能： 在 Analytics -> Browsers 中显示浏览器版本 Report Manager: 使报告阈值（切换到报表管理器之前...","commentCount":0,"href":"https://www.oschina.net/news/86424/countly-17-05-1","id":86424,"pubDate":"2017-07-04 07:22:57","recommend":false,"title":"Countly 17.05.1 发布，实时移动和 web 分析报告平台","type":6,"viewCount":747},{"author":"王练","body":"Fotoxx 17.04.3 已发布，Fotoxx 是一个 Linux 下的开源图形编辑器，它为用户提供了强大的工具来处理使用数码相机制作的图像文件。 Fotoxx 功能强大...","commentCount":2,"href":"https://www.oschina.net/news/86423/fotoxx-17-04-3","id":86423,"pubDate":"2017-07-04 07:22:22","recommend":false,"title":"Fotoxx 17.04.3 发布，功能强大的图片处理软件","type":6,"viewCount":813},{"author":"王练","body":"Lakka 2.1 RC3 已发布，Lakka 是一款轻量级的 Linux 发行版，将小型计算机转变为完整的游戏机。 更新内容： Citra 的 3DS 仿真器可用于 PC 64 位 ...","commentCount":5,"href":"https://www.oschina.net/news/86422/lakka-2-1-rc3","id":86422,"pubDate":"2017-07-04 07:20:25","recommend":false,"title":"Lakka 2.1 RC3 发布，游戏机用的 Linux 发行版","type":6,"viewCount":740},{"author":"王练","body":"Wagtail 1.11 已发布，Wagtail 是一个用 Python 编写的开源 CMS，基于 Django 框架构建。 它优雅、强大、敏捷，专注于灵活性和用户体验，为开发人...","commentCount":0,"href":"https://www.oschina.net/news/86421/wagtail-1-11","id":86421,"pubDate":"2017-07-04 07:19:42","recommend":false,"title":"Wagtail 1.11 发布，基于 Django 的内容管理系统","type":6,"viewCount":601},{"author":"王练","body":"Deployer 5.1.3 已发布，这是一个针对 5.1.2 （此版本修复了并行部署的几个错误，并改进了config：current 和 Symfony recipes ）的修复版本，修复...","commentCount":2,"href":"https://www.oschina.net/news/86420/deployer-5-1-3","id":86420,"pubDate":"2017-07-04 07:18:57","recommend":false,"title":"Deployer 5.1.3 发布，PHP 编写应用部署工具","type":6,"viewCount":623},{"author":"王练","body":"Rockstor 3.9.1 已发布，包含 30 多项更新，主要是一些主要功能更新和 bug 修复。其中，使用 LUKS 磁盘加密是该版本最大的亮点，也是社区一直想要的...","commentCount":0,"href":"https://www.oschina.net/news/86419/rockstor-3-9-1","id":86419,"pubDate":"2017-07-04 07:18:03","recommend":false,"title":"Rockstor 3.9.1 发布，开源 NAS 网络存储系统解决方案","type":6,"viewCount":666}]
         * nextPageToken : DBA816934CD0AA59
         * prevPageToken : 0997C855C600E421
         * requestCount : 20
         * responseCount : 20
         * totalResults : 79442
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
             * author : 王练
             * body : Web 前端框架 Angular.js 1.6.5 发布了，更新内容如下： 新功能 select: 公开控制器中的选择状态信息 $animate: 添加对 customFilter 的支持 $c...
             * commentCount : 14
             * href : https://www.oschina.net/news/86439/angularjs-1-6-5
             * id : 86439
             * pubDate : 2017-07-04 10:30:20
             * recommend : true
             * title : Angular.js 1.6.5 发布，Web 前端框架
             * type : 6
             * viewCount : 793
             */

            private String author;
            private String body;
            private int commentCount;
            private String href;
            private int id;
            private String pubDate;
            private boolean recommend;
            private String title;
            private int type;
            private int viewCount;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
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

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public boolean isRecommend() {
                return recommend;
            }

            public void setRecommend(boolean recommend) {
                this.recommend = recommend;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }
        }
    }
}
