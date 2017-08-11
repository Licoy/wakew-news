<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/16 0016 14:49
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","文章页 - 瓦客新闻网")}
${pageContext.setAttribute("type","page")}
<%@ include file="header.jsp"%>

<!--内容区域-->
<div id="main">
    <!--文章区域-->
    <div id="article" class="articleId_${requestScope.map.news.id}">
        <div class="article-header">
            <div class="article-title">
                <h2>${requestScope.map.news.title}</h2>
            </div>
        </div>
        <div class="article-tool">
            <span title="调整字体" class="ad-font"><i class="fa fa-font"></i><em>+</em></span>
            <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,requestScope.map.news.category)}"><span title="分类"><i class="fa fa-folder-open"></i>
                    ${m:getCategoryNameById(requestScope.map.header.category,requestScope.map.news.category)}
            </span></a>
            <span title="发表日期"><i class="fa fa-clock-o"></i>${m:dateFormat(requestScope.map.news.created)}</span>
            <span title="浏览量"><i class="fa fa-eye"></i>${requestScope.map.news.views}</span>
            <a href="#comments" title="评论"><span><i class="fa fa-comments-o"></i>${requestScope.map.commentsNumber}</span></a>
            <span title="关闭侧边栏" class="on-off-sidebar"><i class="fa fa-toggle-on"></i> 侧边栏</span>
        </div>
        <div class="article-text">
            ${requestScope.map.news.text}
        </div>
        <span class="returnHome">
                    <a href="/" title="点击进入瓦客新闻首页">
                        <img src="${requestScope.map.header.icourlSet}">返回瓦客新闻首页
                    </a>
                </span>
        <div class="share">
            <div id="qrcode" style="display: none;"></div>
            <span>分享至</span>
            <a class="share_qq"><i class="fa fa-qq"></i></a>
            <a class="share_weixin"><i class="fa fa-weixin"></i></a>
            <a class="share_weibo"><i class="fa fa-weibo"></i></a>
            <a class="share_tweibo"><i class="fa fa-tencent-weibo"></i></a>
            <a class="share_twitter"><i class="fa fa-twitter"></i></a>
        </div>

        <!--评论-->
        <div id="comments">
            <div class="count">
                <p><i class="fa fa-user-o"></i>一共有<span>${requestScope.map.commentsNumber}</span>名网友发表了看法</p>
            </div>
            <div id="oldCommentsReply">
                <c:choose>
                    <c:when test="${empty sessionScope.id}">
                        <div class="comments-context" id="commentsReply">
                            <textarea name="" cols="30" rows="6" disabled></textarea>
                            <button type="submit" class="comments-submit" disabled><i class="fa fa-info"></i> 请登陆后进行评论</button>
                            <div class="clear_float"></div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="comments-context" id="commentsReply">
                            <textarea name="" cols="30" rows="6"></textarea>
                            <button type="submit" class="comments-submit">提交评论</button>
                            <div class="clear_float"></div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="comments-list">

                    <c:choose>
                        <c:when test="${!empty requestScope.map.page.attr.comments}">
                            <ul class="ul-list">
                             <li class="start">精彩评论</li>
                            <c:forEach items="${requestScope.map.page.attr.comments}" var="c">
                                <li id="comments-list-${c.comments.id}">
                                    <div class="gravatar">
                                        <img src="${c.user.grava}" alt="${c.user.username}">
                                    </div>
                                    <div class="username">${c.user.username}</div>
                                    <div class="lou"><i class="fa fa-paper-plane-o"></i>#${c.num}</div>
                                    <div class="clear_float"></div>
                                    <div class="text" id="commentsText_${c.comments.id}">
                                        <p class="z">${c.comments.text}</p>
                                        <div class="info">
                                            <span><i class="fa fa-clock-o"></i>${m:dateFormatHasTime(c.comments.issuedate)}</span>
                                            <a id="commentsReply_${c.comments.id}"><span><i class="fa fa-comments-o"></i><em>回复</em></span></a>
                                                <%--<a><span><i class="fa fa-thumbs-o-up"></i>${c.comments.support}</span></a>--%>
                                        </div>
                                        <div class="clear_float"></div>
                                    </div>
                                    <c:if test="${!empty c.contain}">
                                        <c:forEach items="${c.contain}" var="contain">
                                            <div class="c1" id="comments-list-${contain.comments.id}">
                                                <div class="gravatar">
                                                    <img src="${contain.user.grava}" alt="${contain.user.username}">
                                                </div>
                                                <div class="username">${contain.user.username}</div>
                                                <div class="lou"><i class="fa fa-paper-plane-o"></i>#${contain.num}</div>
                                                <div class="clear_float"></div>
                                                <div class="text" id="commentsText_${contain.comments.id}">
                                                    <p class="z">
                                                        <a class="upUser" href="#comments-list-${c.comments.id}">@${c.user.username}</a>
                                                        ${contain.comments.text}
                                                    </p>
                                                    <div class="info">
                                                        <span><i class="fa fa-clock-o"></i>${m:dateFormatHasTime(contain.comments.issuedate)}</span>
                                                        <a id="commentsReply_${contain.comments.id}"><span><i class="fa fa-comments-o"></i><em>回复</em></span></a>
                                                            <%--<a><span><i class="fa fa-thumbs-o-up"></i>${contain.comments.support}</span></a>--%>
                                                    </div>
                                                    <div class="clear_float"></div>
                                                </div>
                                                <c:if test="${!empty contain.contain}">
                                                    <c:forEach items="${contain.contain}" var="contain2">
                                                        <div class="c1" id="comments-list-${contain2.comments.id}">
                                                            <div class="gravatar">
                                                                <img src="${contain2.user.grava}" alt="${contain2.user.username}">
                                                            </div>
                                                            <div class="username">${contain2.user.username}</div>
                                                            <div class="lou"><i class="fa fa-paper-plane-o"></i>#${contain2.num}</div>
                                                            <div class="clear_float"></div>
                                                            <div class="text" id="commentsText_${contain2.comments.id}">
                                                                <p class="z">
                                                                <a class="upUser" href="#comments-list-${contain.comments.id}">@${contain.user.username}</a>
                                                                ${contain2.comments.text}
                                                                </p>
                                                                <div class="info">
                                                                    <span><i class="fa fa-clock-o"></i>${m:dateFormatHasTime(contain2.comments.issuedate)}</span>
                                                                    <a id="commentsReply_${contain2.comments.id}"><span><i class="fa fa-comments-o"></i><em>回复</em></span></a>
                                                                        <%--<a><span><i class="fa fa-thumbs-o-up"></i>${contain2.comments.support}</span></a>--%>
                                                                </div>
                                                                <div class="clear_float"></div>
                                                            </div>
                                                            <c:if test="${!empty contain2.contain}" >
                                                                <c:forEach items="${contain2.contain}" var="contain3">
                                                                    <div class="c1" id="comments-list-${contain3.comments.id}">
                                                                        <div class="gravatar">
                                                                            <img src="${contain3.user.grava}" alt="${contain3.user.username}">
                                                                        </div>
                                                                        <div class="username">${contain3.user.username}</div>
                                                                        <div class="lou"><i class="fa fa-paper-plane-o"></i>#${contain3.num}</div>
                                                                        <div class="clear_float"></div>
                                                                        <div class="text">
                                                                            <p class="z">
                                                                            <a class="upUser" href="#comments-list-${contain2.comments.id}">@${contain2.user.username}</a>
                                                                            ${contain3.comments.text}
                                                                            </p>
                                                                            <div class="info">
                                                                                <span><i class="fa fa-clock-o"></i>${m:dateFormatHasTime(contain3.comments.issuedate)}</span>
                                                                                    <%--<a><span><i class="fa fa-thumbs-o-up"></i>${contain3.comments.support}</span></a>--%>
                                                                            </div>
                                                                            <div class="clear_float"></div>
                                                                        </div>
                                                                    </div>
                                                                </c:forEach>
                                                            </c:if>
                                                        </div>
                                                    </c:forEach>
                                                </c:if>
                                            </div>
                                        </c:forEach>

                                    </c:if>
                                </li>


                            </c:forEach>
                </ul>
                        </c:when>
                        <c:otherwise>
                            <p class="comments-not"><i class="fa fa-ravelry"></i>沙发空位中...</p>
                        </c:otherwise>
                    </c:choose>


            </div>
        </div>
        <c:if test="${!empty requestScope.map.page.attr.comments}">
            <div id="splitPage">
                <ul class="page">
                    <li><a href="${requestScope.map.page.url}#comments">首页</a></li>
                    <c:choose>
                        <c:when test="${requestScope.map.page.nowPageNum-1<=0}">
                            <li disabled="disabled"><a><</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${requestScope.map.page.url}page=${requestScope.map.page.nowPageNum-1}#comments"><</a></li>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach begin="${requestScope.map.page.startPage}" end="${requestScope.map.page.endPage}" var="pageNum">
                        <c:choose>
                            <c:when test="${pageNum==requestScope.map.page.nowPageNum}">
                                <li class="pageActive"><a href="${requestScope.map.page.url}page=${pageNum}#comments">${pageNum}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${requestScope.map.page.url}page=${pageNum}#comments">${pageNum}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${requestScope.map.page.nowPageNum+1>requestScope.map.page.pageNum}">
                            <li disabled="disabled"><a>></a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${requestScope.map.page.url}page=${requestScope.map.page.nowPageNum+1}#comments">></a></li>
                        </c:otherwise>
                    </c:choose>
                    <li><a href="${requestScope.map.page.url}page=${requestScope.map.page.pageNum}#comments">共${requestScope.map.page.pageNum}页</a></li>
                </ul>
            </div>
        </c:if>

    </div>
    <!--侧边栏-->
    <div class="sidebar">
        <c:forEach items="${requestScope.map.Cpsn}" var="cNews">

            <div class="row">
                <div class="title">
                    <span><i class="fa fa-newspaper-o"></i>${m:getCategoryNameById(requestScope.map.header.category,cNews.catId)}</span>
                    <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,cNews.catId)}">更多 <i class="fa fa-caret-right"></i></a>
                    <div class="clear_float"></div>
                </div>
                <div class="content">
                    <ul>
                        <c:forEach items="${cNews.list}" var="news" begin="0" end="0">
                            <li>
                                <a href="/category/${m:getCategoryAliasById(requestScope.map.header.category,cNews.catId)}/${news.news.id}.html" target="_blank">
                                    <img src="${news.imgSrc}" alt="${news.news.title}" title="${news.news.title}">
                                </a>
                                <div class="desc">
                                    <a href="/category/${m:getCategoryAliasById(requestScope.map.header.category,cNews.catId)}/${news.news.id}.html" target="_blank">
                                        <h4>${news.news.title}</h4>
                                    </a>
                                    <p>${m:getAbstract(news.news.text,30)}</p>
                                </div>
                                <div class="clear_float"></div>
                            </li>
                        </c:forEach>
                        <c:forEach items="${cNews.list}" begin="1" var="news">
                            <li class="lists"><a href="/category/${m:getCategoryAliasById(requestScope.map.header.category,cNews.catId)}/${news.news.id}.html" target="_blank" title="${news.news.title}">${news.news.title}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

        </c:forEach>

    </div>
</div>

<%@ include file="footer.jsp"%>
