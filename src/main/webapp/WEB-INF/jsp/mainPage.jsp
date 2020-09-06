	<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<style>
	#line {
	  display: flex;
	}
	
	#borders {
	  margin: 20px;
	}
</style>

<div id="line">

	<%@ include file="Menu.jspf" %>
	
	<div id="borders">
		<title id="borders">Главная страница</title>
		
		  <style type="text/css">
		   ol.lst-kix_c0ryqfe2te8l-1.start{counter-reset:lst-ctn-kix_c0ryqfe2te8l-1 0}ol.lst-kix_1tz36hlpboak-0.start{counter-reset:lst-ctn-kix_1tz36hlpboak-0 0}ol.lst-kix_8cou8sb2uzh4-4.start{counter-reset:lst-ctn-kix_8cou8sb2uzh4-4 0}.lst-kix_ros70ct3o3ad-0>li{counter-increment:lst-ctn-kix_ros70ct3o3ad-0}ol.lst-kix_hb9dujt31tiy-5.start{counter-reset:lst-ctn-kix_hb9dujt31tiy-5 0}.lst-kix_hb9dujt31tiy-0>li{counter-increment:lst-ctn-kix_hb9dujt31tiy-0}.lst-kix_1tz36hlpboak-6>li{counter-increment:lst-ctn-kix_1tz36hlpboak-6}ol.lst-kix_ros70ct3o3ad-6.start{counter-reset:lst-ctn-kix_ros70ct3o3ad-6 0}.lst-kix_8cou8sb2uzh4-3>li{counter-increment:lst-ctn-kix_8cou8sb2uzh4-3}ol.lst-kix_wfmcabjuciz3-6.start{counter-reset:lst-ctn-kix_wfmcabjuciz3-6 0}ol.lst-kix_1tz36hlpboak-6.start{counter-reset:lst-ctn-kix_1tz36hlpboak-6 0}.lst-kix_8cou8sb2uzh4-5>li{counter-increment:lst-ctn-kix_8cou8sb2uzh4-5}.lst-kix_ros70ct3o3ad-2>li{counter-increment:lst-ctn-kix_ros70ct3o3ad-2}.lst-kix_c0ryqfe2te8l-1>li:before{content:"" counter(lst-ctn-kix_c0ryqfe2te8l-1,lower-latin) ". "}ol.lst-kix_wfmcabjuciz3-1.start{counter-reset:lst-ctn-kix_wfmcabjuciz3-1 0}.lst-kix_c0ryqfe2te8l-0>li:before{content:"" counter(lst-ctn-kix_c0ryqfe2te8l-0,decimal) ". "}ol.lst-kix_ros70ct3o3ad-1.start{counter-reset:lst-ctn-kix_ros70ct3o3ad-1 0}.lst-kix_c0ryqfe2te8l-5>li:before{content:"" counter(lst-ctn-kix_c0ryqfe2te8l-5,lower-roman) ". "}.lst-kix_c0ryqfe2te8l-6>li:before{content:"" counter(lst-ctn-kix_c0ryqfe2te8l-6,decimal) ". "}.lst-kix_wfmcabjuciz3-8>li{counter-increment:lst-ctn-kix_wfmcabjuciz3-8}.lst-kix_c0ryqfe2te8l-4>li:before{content:"" counter(lst-ctn-kix_c0ryqfe2te8l-4,lower-latin) ". "}.lst-kix_c0ryqfe2te8l-3>li:before{content:"" counter(lst-ctn-kix_c0ryqfe2te8l-3,decimal) ". "}.lst-kix_8cou8sb2uzh4-3>li:before{content:"" counter(lst-ctn-kix_8cou8sb2uzh4-3,decimal) ". "}ol.lst-kix_c0ryqfe2te8l-7.start{counter-reset:lst-ctn-kix_c0ryqfe2te8l-7 0}.lst-kix_1tz36hlpboak-4>li{counter-increment:lst-ctn-kix_1tz36hlpboak-4}.lst-kix_8cou8sb2uzh4-4>li:before{content:"" counter(lst-ctn-kix_8cou8sb2uzh4-4,lower-latin) ". "}.lst-kix_c0ryqfe2te8l-2>li:before{content:"" counter(lst-ctn-kix_c0ryqfe2te8l-2,lower-roman) ". "}.lst-kix_8cou8sb2uzh4-2>li:before{content:"" counter(lst-ctn-kix_8cou8sb2uzh4-2,lower-roman) ". "}ol.lst-kix_1tz36hlpboak-5.start{counter-reset:lst-ctn-kix_1tz36hlpboak-5 0}.lst-kix_8cou8sb2uzh4-1>li:before{content:"" counter(lst-ctn-kix_8cou8sb2uzh4-1,lower-latin) ". "}ol.lst-kix_wfmcabjuciz3-0.start{counter-reset:lst-ctn-kix_wfmcabjuciz3-0 0}ol.lst-kix_ros70ct3o3ad-7.start{counter-reset:lst-ctn-kix_ros70ct3o3ad-7 0}.lst-kix_8cou8sb2uzh4-0>li:before{content:"" counter(lst-ctn-kix_8cou8sb2uzh4-0,decimal) ". "}.lst-kix_c0ryqfe2te8l-7>li{counter-increment:lst-ctn-kix_c0ryqfe2te8l-7}.lst-kix_c0ryqfe2te8l-7>li:before{content:"" counter(lst-ctn-kix_c0ryqfe2te8l-7,lower-latin) ". "}.lst-kix_c0ryqfe2te8l-8>li:before{content:"" counter(lst-ctn-kix_c0ryqfe2te8l-8,lower-roman) ". "}.lst-kix_ros70ct3o3ad-3>li:before{content:"" counter(lst-ctn-kix_ros70ct3o3ad-3,decimal) ". "}.lst-kix_1tz36hlpboak-2>li{counter-increment:lst-ctn-kix_1tz36hlpboak-2}.lst-kix_ros70ct3o3ad-2>li:before{content:"" counter(lst-ctn-kix_ros70ct3o3ad-2,lower-roman) ". "}.lst-kix_ros70ct3o3ad-6>li:before{content:"" counter(lst-ctn-kix_ros70ct3o3ad-6,decimal) ". "}.lst-kix_ros70ct3o3ad-7>li:before{content:"" counter(lst-ctn-kix_ros70ct3o3ad-7,lower-latin) ". "}.lst-kix_ros70ct3o3ad-1>li:before{content:"" counter(lst-ctn-kix_ros70ct3o3ad-1,lower-latin) ". "}.lst-kix_1tz36hlpboak-8>li{counter-increment:lst-ctn-kix_1tz36hlpboak-8}.lst-kix_hb9dujt31tiy-2>li{counter-increment:lst-ctn-kix_hb9dujt31tiy-2}.lst-kix_ros70ct3o3ad-0>li:before{content:"" counter(lst-ctn-kix_ros70ct3o3ad-0,decimal) ". "}.lst-kix_ros70ct3o3ad-8>li:before{content:"" counter(lst-ctn-kix_ros70ct3o3ad-8,lower-roman) ". "}.lst-kix_1tz36hlpboak-6>li:before{content:"" counter(lst-ctn-kix_1tz36hlpboak-6,decimal) ". "}.lst-kix_1tz36hlpboak-5>li:before{content:"" counter(lst-ctn-kix_1tz36hlpboak-5,lower-roman) ". "}.lst-kix_wfmcabjuciz3-1>li{counter-increment:lst-ctn-kix_wfmcabjuciz3-1}ol.lst-kix_wfmcabjuciz3-5.start{counter-reset:lst-ctn-kix_wfmcabjuciz3-5 0}.lst-kix_1tz36hlpboak-4>li:before{content:"" counter(lst-ctn-kix_1tz36hlpboak-4,lower-latin) ". "}.lst-kix_1tz36hlpboak-2>li:before{content:"" counter(lst-ctn-kix_1tz36hlpboak-2,lower-roman) ". "}ol.lst-kix_c0ryqfe2te8l-2.start{counter-reset:lst-ctn-kix_c0ryqfe2te8l-2 0}.lst-kix_1tz36hlpboak-1>li:before{content:"" counter(lst-ctn-kix_1tz36hlpboak-1,lower-latin) ". "}.lst-kix_1tz36hlpboak-3>li:before{content:"" counter(lst-ctn-kix_1tz36hlpboak-3,decimal) ". "}.lst-kix_ros70ct3o3ad-5>li:before{content:"" counter(lst-ctn-kix_ros70ct3o3ad-5,lower-roman) ". "}ol.lst-kix_ros70ct3o3ad-0.start{counter-reset:lst-ctn-kix_ros70ct3o3ad-0 0}.lst-kix_ros70ct3o3ad-4>li:before{content:"" counter(lst-ctn-kix_ros70ct3o3ad-4,lower-latin) ". "}.lst-kix_wfmcabjuciz3-4>li{counter-increment:lst-ctn-kix_wfmcabjuciz3-4}.lst-kix_wfmcabjuciz3-3>li{counter-increment:lst-ctn-kix_wfmcabjuciz3-3}.lst-kix_1tz36hlpboak-0>li:before{content:"" counter(lst-ctn-kix_1tz36hlpboak-0,decimal) ". "}ol.lst-kix_hb9dujt31tiy-2{list-style-type:none}ol.lst-kix_hb9dujt31tiy-1{list-style-type:none}ol.lst-kix_hb9dujt31tiy-0{list-style-type:none}ol.lst-kix_c0ryqfe2te8l-8.start{counter-reset:lst-ctn-kix_c0ryqfe2te8l-8 0}ol.lst-kix_hb9dujt31tiy-6{list-style-type:none}.lst-kix_ros70ct3o3ad-6>li{counter-increment:lst-ctn-kix_ros70ct3o3ad-6}ol.lst-kix_hb9dujt31tiy-5{list-style-type:none}.lst-kix_hb9dujt31tiy-7>li{counter-increment:lst-ctn-kix_hb9dujt31tiy-7}ol.lst-kix_hb9dujt31tiy-4{list-style-type:none}ol.lst-kix_hb9dujt31tiy-3{list-style-type:none}ol.lst-kix_hb9dujt31tiy-8{list-style-type:none}.lst-kix_c0ryqfe2te8l-3>li{counter-increment:lst-ctn-kix_c0ryqfe2te8l-3}ol.lst-kix_hb9dujt31tiy-7{list-style-type:none}ol.lst-kix_ros70ct3o3ad-7{list-style-type:none}ol.lst-kix_ros70ct3o3ad-8{list-style-type:none}.lst-kix_c0ryqfe2te8l-4>li{counter-increment:lst-ctn-kix_c0ryqfe2te8l-4}.lst-kix_1tz36hlpboak-7>li:before{content:"" counter(lst-ctn-kix_1tz36hlpboak-7,lower-latin) ". "}ol.lst-kix_ros70ct3o3ad-5{list-style-type:none}ol.lst-kix_ros70ct3o3ad-6{list-style-type:none}.lst-kix_wfmcabjuciz3-2>li{counter-increment:lst-ctn-kix_wfmcabjuciz3-2}ol.lst-kix_ros70ct3o3ad-0{list-style-type:none}ol.lst-kix_ros70ct3o3ad-3{list-style-type:none}.lst-kix_ros70ct3o3ad-7>li{counter-increment:lst-ctn-kix_ros70ct3o3ad-7}ol.lst-kix_ros70ct3o3ad-4{list-style-type:none}.lst-kix_hb9dujt31tiy-6>li{counter-increment:lst-ctn-kix_hb9dujt31tiy-6}ol.lst-kix_ros70ct3o3ad-1{list-style-type:none}ol.lst-kix_ros70ct3o3ad-2{list-style-type:none}ol.lst-kix_8cou8sb2uzh4-5.start{counter-reset:lst-ctn-kix_8cou8sb2uzh4-5 0}.lst-kix_8cou8sb2uzh4-8>li{counter-increment:lst-ctn-kix_8cou8sb2uzh4-8}.lst-kix_c0ryqfe2te8l-2>li{counter-increment:lst-ctn-kix_c0ryqfe2te8l-2}ol.lst-kix_ros70ct3o3ad-8.start{counter-reset:lst-ctn-kix_ros70ct3o3ad-8 0}.lst-kix_ros70ct3o3ad-8>li{counter-increment:lst-ctn-kix_ros70ct3o3ad-8}ol.lst-kix_hb9dujt31tiy-4.start{counter-reset:lst-ctn-kix_hb9dujt31tiy-4 0}ol.lst-kix_1tz36hlpboak-7.start{counter-reset:lst-ctn-kix_1tz36hlpboak-7 0}.lst-kix_8cou8sb2uzh4-5>li:before{content:"" counter(lst-ctn-kix_8cou8sb2uzh4-5,lower-roman) ". "}ol.lst-kix_c0ryqfe2te8l-6.start{counter-reset:lst-ctn-kix_c0ryqfe2te8l-6 0}ol.lst-kix_wfmcabjuciz3-7.start{counter-reset:lst-ctn-kix_wfmcabjuciz3-7 0}.lst-kix_8cou8sb2uzh4-7>li:before{content:"" counter(lst-ctn-kix_8cou8sb2uzh4-7,lower-latin) ". "}ol.lst-kix_1tz36hlpboak-8.start{counter-reset:lst-ctn-kix_1tz36hlpboak-8 0}.lst-kix_1tz36hlpboak-3>li{counter-increment:lst-ctn-kix_1tz36hlpboak-3}ol.lst-kix_8cou8sb2uzh4-2.start{counter-reset:lst-ctn-kix_8cou8sb2uzh4-2 0}.lst-kix_wfmcabjuciz3-0>li:before{content:"" counter(lst-ctn-kix_wfmcabjuciz3-0,decimal) ". "}ol.lst-kix_hb9dujt31tiy-6.start{counter-reset:lst-ctn-kix_hb9dujt31tiy-6 0}.lst-kix_wfmcabjuciz3-2>li:before{content:"" counter(lst-ctn-kix_wfmcabjuciz3-2,lower-roman) ". "}ol.lst-kix_c0ryqfe2te8l-5.start{counter-reset:lst-ctn-kix_c0ryqfe2te8l-5 0}ol.lst-kix_wfmcabjuciz3-8.start{counter-reset:lst-ctn-kix_wfmcabjuciz3-8 0}ol.lst-kix_8cou8sb2uzh4-3.start{counter-reset:lst-ctn-kix_8cou8sb2uzh4-3 0}.lst-kix_wfmcabjuciz3-6>li:before{content:"" counter(lst-ctn-kix_wfmcabjuciz3-6,decimal) ". "}.lst-kix_8cou8sb2uzh4-7>li{counter-increment:lst-ctn-kix_8cou8sb2uzh4-7}ol.lst-kix_c0ryqfe2te8l-2{list-style-type:none}ol.lst-kix_c0ryqfe2te8l-3{list-style-type:none}.lst-kix_wfmcabjuciz3-4>li:before{content:"" counter(lst-ctn-kix_wfmcabjuciz3-4,lower-latin) ". "}.lst-kix_wfmcabjuciz3-8>li:before{content:"" counter(lst-ctn-kix_wfmcabjuciz3-8,lower-roman) ". "}ol.lst-kix_c0ryqfe2te8l-0{list-style-type:none}ol.lst-kix_c0ryqfe2te8l-1{list-style-type:none}ol.lst-kix_c0ryqfe2te8l-6{list-style-type:none}ol.lst-kix_c0ryqfe2te8l-7{list-style-type:none}ol.lst-kix_c0ryqfe2te8l-4{list-style-type:none}ol.lst-kix_c0ryqfe2te8l-5{list-style-type:none}ol.lst-kix_c0ryqfe2te8l-8{list-style-type:none}.lst-kix_8cou8sb2uzh4-1>li{counter-increment:lst-ctn-kix_8cou8sb2uzh4-1}ol.lst-kix_1tz36hlpboak-3.start{counter-reset:lst-ctn-kix_1tz36hlpboak-3 0}.lst-kix_ros70ct3o3ad-1>li{counter-increment:lst-ctn-kix_ros70ct3o3ad-1}.lst-kix_8cou8sb2uzh4-2>li{counter-increment:lst-ctn-kix_8cou8sb2uzh4-2}ol.lst-kix_8cou8sb2uzh4-7.start{counter-reset:lst-ctn-kix_8cou8sb2uzh4-7 0}ol.lst-kix_wfmcabjuciz3-3.start{counter-reset:lst-ctn-kix_wfmcabjuciz3-3 0}.lst-kix_c0ryqfe2te8l-8>li{counter-increment:lst-ctn-kix_c0ryqfe2te8l-8}ol.lst-kix_c0ryqfe2te8l-4.start{counter-reset:lst-ctn-kix_c0ryqfe2te8l-4 0}.lst-kix_1tz36hlpboak-7>li{counter-increment:lst-ctn-kix_1tz36hlpboak-7}.lst-kix_hb9dujt31tiy-1>li{counter-increment:lst-ctn-kix_hb9dujt31tiy-1}ol.lst-kix_8cou8sb2uzh4-1.start{counter-reset:lst-ctn-kix_8cou8sb2uzh4-1 0}ol.lst-kix_hb9dujt31tiy-7.start{counter-reset:lst-ctn-kix_hb9dujt31tiy-7 0}ol.lst-kix_8cou8sb2uzh4-6.start{counter-reset:lst-ctn-kix_8cou8sb2uzh4-6 0}.lst-kix_ros70ct3o3ad-3>li{counter-increment:lst-ctn-kix_ros70ct3o3ad-3}ol.lst-kix_wfmcabjuciz3-4.start{counter-reset:lst-ctn-kix_wfmcabjuciz3-4 0}ol.lst-kix_c0ryqfe2te8l-3.start{counter-reset:lst-ctn-kix_c0ryqfe2te8l-3 0}.lst-kix_hb9dujt31tiy-4>li:before{content:"" counter(lst-ctn-kix_hb9dujt31tiy-4,lower-latin) ". "}.lst-kix_8cou8sb2uzh4-0>li{counter-increment:lst-ctn-kix_8cou8sb2uzh4-0}.lst-kix_hb9dujt31tiy-5>li:before{content:"" counter(lst-ctn-kix_hb9dujt31tiy-5,lower-roman) ". "}.lst-kix_c0ryqfe2te8l-1>li{counter-increment:lst-ctn-kix_c0ryqfe2te8l-1}.lst-kix_hb9dujt31tiy-7>li:before{content:"" counter(lst-ctn-kix_hb9dujt31tiy-7,lower-latin) ". "}.lst-kix_8cou8sb2uzh4-6>li{counter-increment:lst-ctn-kix_8cou8sb2uzh4-6}ol.lst-kix_hb9dujt31tiy-3.start{counter-reset:lst-ctn-kix_hb9dujt31tiy-3 0}.lst-kix_hb9dujt31tiy-6>li:before{content:"" counter(lst-ctn-kix_hb9dujt31tiy-6,decimal) ". "}.lst-kix_hb9dujt31tiy-8>li:before{content:"" counter(lst-ctn-kix_hb9dujt31tiy-8,lower-roman) ". "}ol.lst-kix_8cou8sb2uzh4-0.start{counter-reset:lst-ctn-kix_8cou8sb2uzh4-0 0}ol.lst-kix_hb9dujt31tiy-8.start{counter-reset:lst-ctn-kix_hb9dujt31tiy-8 0}.lst-kix_hb9dujt31tiy-8>li{counter-increment:lst-ctn-kix_hb9dujt31tiy-8}.lst-kix_1tz36hlpboak-5>li{counter-increment:lst-ctn-kix_1tz36hlpboak-5}.lst-kix_hb9dujt31tiy-5>li{counter-increment:lst-ctn-kix_hb9dujt31tiy-5}.lst-kix_hb9dujt31tiy-3>li:before{content:"" counter(lst-ctn-kix_hb9dujt31tiy-3,decimal) ". "}.lst-kix_hb9dujt31tiy-2>li:before{content:"" counter(lst-ctn-kix_hb9dujt31tiy-2,lower-roman) ". "}.lst-kix_hb9dujt31tiy-1>li:before{content:"" counter(lst-ctn-kix_hb9dujt31tiy-1,lower-latin) ". "}.lst-kix_hb9dujt31tiy-0>li:before{content:"" counter(lst-ctn-kix_hb9dujt31tiy-0,decimal) ". "}.lst-kix_wfmcabjuciz3-7>li{counter-increment:lst-ctn-kix_wfmcabjuciz3-7}ol.lst-kix_hb9dujt31tiy-2.start{counter-reset:lst-ctn-kix_hb9dujt31tiy-2 0}ol.lst-kix_8cou8sb2uzh4-0{list-style-type:none}ol.lst-kix_8cou8sb2uzh4-1{list-style-type:none}ol.lst-kix_8cou8sb2uzh4-4{list-style-type:none}ol.lst-kix_8cou8sb2uzh4-5{list-style-type:none}ol.lst-kix_8cou8sb2uzh4-2{list-style-type:none}ol.lst-kix_8cou8sb2uzh4-3{list-style-type:none}ol.lst-kix_8cou8sb2uzh4-8{list-style-type:none}ol.lst-kix_8cou8sb2uzh4-6{list-style-type:none}ol.lst-kix_8cou8sb2uzh4-7{list-style-type:none}ol.lst-kix_ros70ct3o3ad-2.start{counter-reset:lst-ctn-kix_ros70ct3o3ad-2 0}ol.lst-kix_1tz36hlpboak-0{list-style-type:none}ol.lst-kix_1tz36hlpboak-1{list-style-type:none}ol.lst-kix_8cou8sb2uzh4-8.start{counter-reset:lst-ctn-kix_8cou8sb2uzh4-8 0}ol.lst-kix_1tz36hlpboak-4{list-style-type:none}.lst-kix_1tz36hlpboak-8>li:before{content:"" counter(lst-ctn-kix_1tz36hlpboak-8,lower-roman) ". "}ol.lst-kix_1tz36hlpboak-5{list-style-type:none}ol.lst-kix_1tz36hlpboak-2{list-style-type:none}ol.lst-kix_1tz36hlpboak-3{list-style-type:none}ol.lst-kix_1tz36hlpboak-8{list-style-type:none}ol.lst-kix_1tz36hlpboak-6{list-style-type:none}ol.lst-kix_1tz36hlpboak-7{list-style-type:none}ol.lst-kix_wfmcabjuciz3-3{list-style-type:none}ol.lst-kix_hb9dujt31tiy-1.start{counter-reset:lst-ctn-kix_hb9dujt31tiy-1 0}ol.lst-kix_wfmcabjuciz3-4{list-style-type:none}.lst-kix_ros70ct3o3ad-5>li{counter-increment:lst-ctn-kix_ros70ct3o3ad-5}ol.lst-kix_wfmcabjuciz3-5{list-style-type:none}ol.lst-kix_wfmcabjuciz3-6{list-style-type:none}.lst-kix_c0ryqfe2te8l-5>li{counter-increment:lst-ctn-kix_c0ryqfe2te8l-5}ol.lst-kix_wfmcabjuciz3-0{list-style-type:none}ol.lst-kix_wfmcabjuciz3-1{list-style-type:none}ol.lst-kix_wfmcabjuciz3-2{list-style-type:none}.lst-kix_wfmcabjuciz3-5>li{counter-increment:lst-ctn-kix_wfmcabjuciz3-5}ol.lst-kix_1tz36hlpboak-4.start{counter-reset:lst-ctn-kix_1tz36hlpboak-4 0}ol.lst-kix_c0ryqfe2te8l-0.start{counter-reset:lst-ctn-kix_c0ryqfe2te8l-0 0}ol.lst-kix_ros70ct3o3ad-5.start{counter-reset:lst-ctn-kix_ros70ct3o3ad-5 0}.lst-kix_hb9dujt31tiy-4>li{counter-increment:lst-ctn-kix_hb9dujt31tiy-4}ol.lst-kix_wfmcabjuciz3-7{list-style-type:none}.lst-kix_1tz36hlpboak-1>li{counter-increment:lst-ctn-kix_1tz36hlpboak-1}ol.lst-kix_wfmcabjuciz3-8{list-style-type:none}.lst-kix_8cou8sb2uzh4-6>li:before{content:"" counter(lst-ctn-kix_8cou8sb2uzh4-6,decimal) ". "}.lst-kix_wfmcabjuciz3-6>li{counter-increment:lst-ctn-kix_wfmcabjuciz3-6}.lst-kix_c0ryqfe2te8l-6>li{counter-increment:lst-ctn-kix_c0ryqfe2te8l-6}.lst-kix_c0ryqfe2te8l-0>li{counter-increment:lst-ctn-kix_c0ryqfe2te8l-0}ol.lst-kix_hb9dujt31tiy-0.start{counter-reset:lst-ctn-kix_hb9dujt31tiy-0 0}.lst-kix_8cou8sb2uzh4-8>li:before{content:"" counter(lst-ctn-kix_8cou8sb2uzh4-8,lower-roman) ". "}.lst-kix_wfmcabjuciz3-0>li{counter-increment:lst-ctn-kix_wfmcabjuciz3-0}.lst-kix_hb9dujt31tiy-3>li{counter-increment:lst-ctn-kix_hb9dujt31tiy-3}ol.lst-kix_1tz36hlpboak-1.start{counter-reset:lst-ctn-kix_1tz36hlpboak-1 0}ol.lst-kix_ros70ct3o3ad-4.start{counter-reset:lst-ctn-kix_ros70ct3o3ad-4 0}.lst-kix_ros70ct3o3ad-4>li{counter-increment:lst-ctn-kix_ros70ct3o3ad-4}ol.lst-kix_ros70ct3o3ad-3.start{counter-reset:lst-ctn-kix_ros70ct3o3ad-3 0}.lst-kix_wfmcabjuciz3-1>li:before{content:"" counter(lst-ctn-kix_wfmcabjuciz3-1,lower-latin) ". "}.lst-kix_wfmcabjuciz3-3>li:before{content:"" counter(lst-ctn-kix_wfmcabjuciz3-3,decimal) ". "}.lst-kix_1tz36hlpboak-0>li{counter-increment:lst-ctn-kix_1tz36hlpboak-0}.lst-kix_wfmcabjuciz3-5>li:before{content:"" counter(lst-ctn-kix_wfmcabjuciz3-5,lower-roman) ". "}ol.lst-kix_1tz36hlpboak-2.start{counter-reset:lst-ctn-kix_1tz36hlpboak-2 0}.lst-kix_8cou8sb2uzh4-4>li{counter-increment:lst-ctn-kix_8cou8sb2uzh4-4}ol.lst-kix_wfmcabjuciz3-2.start{counter-reset:lst-ctn-kix_wfmcabjuciz3-2 0}.lst-kix_wfmcabjuciz3-7>li:before{content:"" counter(lst-ctn-kix_wfmcabjuciz3-7,lower-latin) ". "}ol{margin:0;padding:0}table td,table th{padding:0}.c6{margin-left:36pt;padding-top:0pt;padding-left:0pt;padding-bottom:0pt;line-height:1.15;orphans:2;widows:2;text-align:left}.c7{margin-left:72pt;padding-top:0pt;padding-left:0pt;padding-bottom:0pt;line-height:1.15;orphans:2;widows:2;text-align:left}.c9{color:#000000;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:11pt;font-family:"Arial";font-style:normal}.c15{color:#000000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:16pt;font-family:"Arial";font-style:normal}.c0{color:#000000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:11pt;font-family:"Arial";font-style:normal}.c12{color:#000000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:20pt;font-family:"Arial";font-style:normal}.c8{margin-left:18pt;padding-top:3pt;padding-bottom:0pt;line-height:1.0;orphans:2;widows:2;text-align:left}.c5{padding-top:18pt;padding-bottom:6pt;line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}.c13{color:#000000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:10pt;font-family:"Arial";font-style:normal}.c11{padding-top:20pt;padding-bottom:6pt;line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}.c10{padding-top:0pt;padding-bottom:0pt;line-height:1.15;orphans:2;widows:2;text-align:left}.c2{padding-top:10pt;padding-bottom:0pt;line-height:1.0;orphans:2;widows:2;text-align:left}.c16{padding-top:4pt;padding-bottom:0pt;line-height:1.0;orphans:2;widows:2;text-align:left}.c19{padding-top:10pt;padding-bottom:4pt;line-height:1.0;orphans:2;widows:2;text-align:left}.c17{padding-top:0pt;padding-bottom:0pt;line-height:1.15;orphans:2;widows:2;text-align:right}.c3{text-decoration-skip-ink:none;font-size:10pt;-webkit-text-decoration-skip:none;color:#1155cc;text-decoration:underline}.c20{text-decoration-skip-ink:none;-webkit-text-decoration-skip:none;color:#1155cc;text-decoration:underline}.c18{background-color:#ffffff;max-width:451.4pt;padding:72pt 72pt 72pt 72pt}.c4{padding:0;margin:0}.c1{color:inherit;text-decoration:inherit}.c14{height:11pt}.title{padding-top:0pt;color:#000000;font-size:26pt;padding-bottom:3pt;font-family:"Arial";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}.subtitle{padding-top:0pt;color:#666666;font-size:15pt;padding-bottom:16pt;font-family:"Arial";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}li{color:#000000;font-size:11pt;font-family:"Arial"}p{margin:0;color:#000000;font-size:11pt;font-family:"Arial"}h1{padding-top:20pt;color:#000000;font-size:20pt;padding-bottom:6pt;font-family:"Arial";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h2{padding-top:18pt;color:#000000;font-size:16pt;padding-bottom:6pt;font-family:"Arial";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h3{padding-top:16pt;color:#434343;font-size:14pt;padding-bottom:4pt;font-family:"Arial";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h4{padding-top:14pt;color:#666666;font-size:12pt;padding-bottom:4pt;font-family:"Arial";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h5{padding-top:12pt;color:#666666;font-size:11pt;padding-bottom:4pt;font-family:"Arial";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h6{padding-top:12pt;color:#666666;font-size:11pt;padding-bottom:4pt;font-family:"Arial";line-height:1.15;page-break-after:avoid;font-style:italic;orphans:2;widows:2;text-align:left}
		  </style>

		  <h1 class="c11" id="h.ujnqfbs0d4xj">
		   <span class="c12">
		    Сценарии использования
		   </span>
		  </h1>
		  <h2 class="c5" id="h.351krzksdc1r">
		   <span class="c15">
		    Получение списка клиентов
		   </span>
		  </h2>
		  <ol class="c4 lst-kix_ros70ct3o3ad-0 start" start="1">
		   <li class="c6">
		    <span class="c0">
		     Через меню переходим к истории обращений
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     Настраиваем требуемые фильтры: в фильтрах можно указывать даты фильтрации, типы услуг, участвующих сотрудников
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     В поле с названием/именем клиента получаем список, удовлетворяющий условиям фильтрации
		    </span>
		   </li>
		  </ol>
		  <h2 class="c5" id="h.r60l9qpd9x3b">
		   <span class="c15">
		    Получение списка служащих
		   </span>
		  </h2>
		  <ol class="c4 lst-kix_1tz36hlpboak-0 start" start="1">
		   <li class="c6">
		    <span class="c0">
		     Через меню переходим к истории обращений
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     Настраиваем фильтры аналогичным образом, фильтр на название/имя клиента тоже есть
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     В поле с именем сотрудника получаем список, удовлетворяющий условиям фильтрации
		    </span>
		   </li>
		  </ol>
		  <p class="c10 c14">
		   <span class="c0">
		   </span>
		  </p>
		  <h2 class="c5" id="h.vnzquwr02j1d">
		   <span class="c15">
		    Добавление, удаление, редактирование данных о клиенте
		   </span>
		  </h2>
		  <ol class="c4 lst-kix_c0ryqfe2te8l-0 start" start="1">
		   <li class="c6">
		    <span class="c0">
		     Через меню переходим к данным клиентов
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     Если нужно создать клиента в базе - найти кнопку “зарегистрировать нового клиента”
		    </span>
		   </li>
		  </ol>
		  <ol class="c4 lst-kix_c0ryqfe2te8l-1 start" start="1">
		   <li class="c7">
		    <span class="c0">
		     Дальше нужно заполнить все необходимые поля, помеченные звездочкой и нажать “Сохранить”
		    </span>
		   </li>
		  </ol>
		  <ol class="c4 lst-kix_c0ryqfe2te8l-0" start="3">
		   <li class="c6">
		    <span class="c0">
		     В любом ином случае его нужно найти в базе через поисковую строку, по имени или названию
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     В случае, если поиск выдал несколько результатов, надо понять, какой вам нужен и тыкнуть на него
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     Для удаления клиенты из базы есть специальная кнопка, ее использование валидируется ответственным лицом
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     Все поля являются редактируемыми, после редакции нужно нажать кнопку “Сохранить”
		    </span>
		   </li>
		  </ol>
		  <ol class="c4 lst-kix_c0ryqfe2te8l-1 start" start="1">
		   <li class="c7">
		    <span class="c0">
		     При попытке уйти со страницы, на которой были несохраненные изменения появится предупреждение
		    </span>
		   </li>
		  </ol>
		  <ol class="c4 lst-kix_c0ryqfe2te8l-0" start="7">
		   <li class="c6">
		    <span class="c0">
		     Также для юридических компаний есть возможность добавления контактных лиц, и для любых клиентов - добавления их контактов
		    </span>
		   </li>
		  </ol>
		  <h2 class="c5" id="h.v4ydkgvf50j1">
		   <span class="c15">
		    Добавление, удаление, редактирование данных о служащих
		   </span>
		  </h2>
		  <ol class="c4 lst-kix_wfmcabjuciz3-0 start" start="1">
		   <li class="c6">
		    <span class="c0">
		     Через меню переходим к данным сотрудников
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     Аналогично предыдущему пункту, но для служащих также есть возможность поставить статус - работает/уволен/в отпуске
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     Если нужно создать сотрудника в базе - найти кнопку “зарегистрировать нового сотрудника”
		    </span>
		   </li>
		  </ol>
		  <ol class="c4 lst-kix_wfmcabjuciz3-1 start" start="1">
		   <li class="c7">
		    <span class="c0">
		     Дальше нужно заполнить все необходимые поля, помеченные звездочкой и нажать “Сохранить”
		    </span>
		   </li>
		  </ol>
		  <ol class="c4 lst-kix_wfmcabjuciz3-0" start="4">
		   <li class="c6">
		    <span class="c0">
		     В любом ином случае его нужно найти в базе через поисковую строку, по имени
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     В случае, если поиск выдал несколько результатов, надо понять, какой вам нужен и тыкнуть на него
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     Для удаления сотрудника из базы есть специальная кнопка, ее использование валидируется ответственным лицом
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     Все поля являются редактируемыми, после редакции нужно нажать кнопку “Сохранить”
		    </span>
		   </li>
		  </ol>
		  <ol class="c4 lst-kix_wfmcabjuciz3-1 start" start="1">
		   <li class="c7">
		    <span class="c0">
		     При попытке уйти со страницы, на которой были несохраненные изменения появится предупреждение
		    </span>
		   </li>
		  </ol>
		  <p class="c10 c14">
		   <span class="c0">
		   </span>
		  </p>
		  <p class="c10 c14">
		   <span class="c0">
		   </span>
		  </p>
		  <h2 class="c5" id="h.kzg44uoi7qio">
		   <span class="c15">
		    Регистрация нового договора
		   </span>
		  </h2>
		  <ol class="c4 lst-kix_8cou8sb2uzh4-0 start" start="1">
		   <li class="c6">
		    <span class="c0">
		     Для начала процедуры регистрации на главной странице сайта есть кнопка - “зарегистрировать договор”
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     На самом деле, она адресует на страницу поиска по клиентам
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     После нахождения нужного клиента, на странице чтения/редактирования его данных надо найти кнопку -”зарегистрировать договор”
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     На появившейся странице надо проверить правильность указанных данных клиента, выбрать тип оказываемой услуги и нажать кнопку зарегистрировать
		    </span>
		   </li>
		   <li class="c6">
		    <span class="c0">
		     В случае, если нужно зарегистрировать договор с новым клиентом, нужно сначала внести его в базу (см. Добавление, удаление, редактирование данных о клиенте)
		    </span>
		   </li>
		  </ol>
		</div>		
	</div>
</div>