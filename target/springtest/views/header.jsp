<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<title>.....</title>
 <style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css'>
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/css/bootstrap-datetimepicker.min.css'>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
</head>
<spring:url value="listOrder?orderName=id" var="urlOrderById" /> 
 <spring:url value="listOrder?orderName=TitleCustomer" var="urlOrderByTitle" />
 <spring:url value="listOrder?orderName=Firstname" var="urlOrderByFirstName" />
 <spring:url value="listOrder?orderName=Lastname" var="urlOrderByLastName" />
 <spring:url value="listOrder?orderName=ScheduledDate" var="urlOrderByScheduledDate" />
<jsp:include page="navigationBar.jsp" />

