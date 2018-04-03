<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>네이버 :: 페이지를 찾을 수 없습니다.</title>
<script type=text/javascript> 
var defaultCharset = document.charset ;
function isIE(){ return /msie/i.test(navigator.userAgent) && !/opera/i.test(navigator.userAgent); }
function setDefaultCharset() { document.charset = defaultCharset ; }
function emulAcceptCharset(form) { if (isIE) { var defCharset = document.charset ; document.charset = form.acceptCharset ; window.onbeforeunload = setDefaultCharset ; } return true; }
</script>
</head>

<body>
<style>
a { cursor: pointer; }
@charset "utf-8";
*{margin:0;padding:0;}
body{background:url(https://s.pstatic.net/static/w8/err/bg_body.gif) repeat-x;color:#444;font:12px/1.7em 굴림,Gulim,AppleGothic,sans-serif;text-align:center;}
img,fieldset{border:none;}
a{color:#438a01;text-decoration:underline;}
legend{display:none;}

#wrap{width:560px;_height:618px;min-height:618px;margin:0 auto;background:url(https://s.pstatic.net/static/w8/err/bg_naver.gif) no-repeat 100% 109px;text-align:left;}

#header{overflow:hidden;position:relative;height:80px;}
#header h1{margin:36px 0 0 26px;}
#header .menu{overflow:hidden;position:absolute;top:23px;right:28px;width:100%;color:#d7d7d7;font-family:돋움,Dotum;letter-spacing:-1px;text-align:right;}
#header .menu a{margin:0 3px;color:#444;text-decoration:none;}
#header .menu a:hover{text-decoration:underline;}

#container{padding:33px 20px 0 81px;}
#container h2{margin-bottom:24px;font:bold 14px/1.6em 돋움,Dotum;letter-spacing:-1px;}
#container .content p{margin-bottom:10px;}
.search{margin-top:30px;}
.window02{margin-bottom:0;}
.box_window{width:320px;height:22px;_height /**/:32px;margin:0 3px 11px 1px;padding:1px 3px 0 6px;border:5px solid #4ba300;background-color:#fff;font:bold 15px/1.5em 돋움,Dotum;vertical-align:4px;}
*+html .box_window{vertical-align:4px;}
.btn_window{vertical-align:top;_vertical-align:0;_vertical-align /**/:top;}
.sch_desc{width:391px;text-align:center;}
.sch_link{width:391px;margin-left:-1px;color:#dedede;text-align:center;}
.sch_link a{margin:0 3px;color:#444;text-decoration:none;}
.sch_link a:hover{text-decoration:underline;}

#footer{margin-top:80px;text-align:center;}
#footer a {text-decoration:none; color:#333;}
#footer a:visited {text-decoration:none; color:#666;}/* 090923 해당라인 삭제 */
#footer a:hover {text-decoration:underline;}
#footer address {font:9px/14px Verdana;}
#footer address img {vertical-align:middle;}
#footer address a {font:bold 9px Tahoma; color:#333;}
#footer address a:hover {color:#009bc8;}
#footer address span {padding-left:2px; font:9px/14px Verdana;}
#footer address em {padding-left:6px; font:9px verdana;}
#footer address .logo {display:inline-block; *display:inline; vertical-align:top; *vertical-align:baseline;}



</style>
<div id="wrap">
    <div id="header">
        <h1><a href="http://www.naver.com/"><img src="https://s.pstatic.net/static/w8/err/lg_naver.gif" alt="NAVER" width="145" height="33" /></a></h1>
        <p class="menu"><a href="http://www.naver.com/">민경홈</a> | <a onclick="window.open('https://help.naver.com/support/alias/contents2/naverhome/notfound.naver', 'help_naver', 'left=40,top=60,width=650,height=800,toolbar=1,resizable=0'); return false;">네이버 고객센터</a></p>
    </div>
    <div id="container">
        <h2>죄송합니다.<br />요청하신 페이지를 찾을 수 없습니다.</h2>
        <div class="content">
            <p>방문하시려는 페이지의 주소가 잘못 입력되었거나,<br />페이지의 주소가 변경 혹은 삭제되어 요청하신 페이지를 찾을 수 없습니다.</p>
            <p>입력하신 주소가 정확한지 다시 한번 확인해 주시기 바랍니다.</p>
            <p>관련 문의사항은 <a onclick="window.open('https://help.naver.com/support/alias/contents2/naverhome/notfound.naver', 'help_naver', 'left=40,top=60,width=650,height=800,toolbar=1,resizable=0'); return false;">네이버 고객센터</a>에 알려주시면 친절하게 안내해 드리겠습니다.</p>
            <p>감사합니다.</p>
        </div>
        <form class="search" style="margin-top:50px;" name="search" action="http://search.naver.com/search.naver" method="get" onsubmit="emulAcceptCharset(this);" accept-charset="ks_c_5601-1987">
            <input type="hidden" name="sm" value="nnf_hty">
            <fieldset class="window02">
                <legend>검색</legend>
                <input type="text" title="검색" name="query" maxlength="255" value="" class="box_window" accesskey="s">
                <input src="https://s.pstatic.net/static/w8/err/btn_sch.gif" onmouseover="this.src='https://s.pstatic.net/static/w8/err/btn_sch_over.gif'" onmouseout="this.src='https://s.pstatic.net/static/w8/err/btn_sch.gif'" alt="검색" type="image" class="btn_window">
            </fieldset>
            <p class="sch_desc">네이버 검색으로 원하시는 페이지를 찾으실 수 있습니다.</p>
        </form>
    </div>
<div id="footer">
<address>
    <a href="http://www.nhncorp.com/" target="_blank" class="logo"><img src="https://s.pstatic.net/static/common/footer/logo_naver.gif" width="63" height="15" alt="NAVER"></a>
    <em>Copyright &copy;</em>
    <a href="http://www.nhncorp.com/" target="_blank">NAVER Corp.</a>
    <span>All Rights Reserved.</span>
</address>
</div>
</div>

</body>
</html>

