<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 

<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">

<jsp:include page="header.jsp" />
<body>
<div class="container">
    <div class="row">
	   <h2><spring:message code="lbl.page" text="All Employees in System" /></h2>
       <c:if test="${not empty name}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${name}</strong>
			</div>
		</c:if>
      </div>
		
	<div class="col-md-10 col-md-offset-1">
		<div class="panel panel-default panel-table">
		<div class="panel-heading">
                <div class="row">
                  <div class="col col-xs-6 text-right">
                     <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Open Modal</button>
                  </div>
                </div>
              </div>
               <div class="panel-body">
                <table class="table table-striped table-bordered table-list">
                  <thead>
                    <tr>
                         <th><spring:message code="task.Id" text="Action" /></th>
                         <th><a href="listOrder?orderName=id"><spring:message code="lbl.Id" text="Task-Id" /></a></th>
                         <th><a href="listOrder?orderName=TitleCustomer"><spring:message code="task.customer.title" text="Title Customer" /></a></th>
                         <th><a href="listOrder?orderName=Firstname"><spring:message code="lbl.firstName" text="First Name" /></a></th>
                         <th><a href="listOrder?orderName=Lastname"><spring:message code="lbl.lastName" text="Last Name" /></a></th>
                         <th><a href="listOrder?orderName=ScheduledDate"><spring:message code="lbl.scheduledDate" text="Scheduled Date" /></a></th>
                    </tr> 
                  </thead>
                  <tbody>
                     <c:if test="${not empty initListTask}">
	                   <c:forEach var="taskRow" items="${initListTask}">
                          <tr>
                            <td align="center">
                                  <spring:url value="delete?idTask=${taskRow.idTask}" var="deleteUrl" />
	                              <a class="btn btn-info" data-toggle="modal" onclick="openModelWithParam('${taskRow.titleCustomer}','${taskRow.scheduledDate}','${taskRow.lastname}','${taskRow.firstname}','${taskRow.idTask}','${taskRow.notes}'); return false;"><em class="fa fa-pencil"></em></a>
	                              <a class="btn btn-danger" href="${deleteUrl}" ><em class="fa fa-trash"></em></a>
                            </td>
                            <td>${taskRow.idTask}</td>
                            <td>${taskRow.titleCustomer}</td>
                            <td>${taskRow.firstname}</td>
                            <td>${taskRow.lastname}</td>
                            <td>${taskRow.scheduledDate}</td>
                          </tr>
	                  </c:forEach>
	                  </c:if>
	                    <c:if test="${empty initListTask}">
	                        <tr><td><spring:message code="table.empty" /></td></tr>
	                  </c:if>
                  </tbody>
          </table>
		 </div>
		<div class="panel-footer">
	                <div class="row">
	                  <div class="col col-xs-4">Page 1 of 5
	                  </div>
	                  <div class="col col-xs-8">
	                    <ul class="pagination hidden-xs pull-right">
	                      <li><a href="#">1</a></li>
	                      <li><a href="#">2</a></li>
	                      <li><a href="#">3</a></li>
	                      <li><a href="#">4</a></li>
	                      <li><a href="#">5</a></li>
	                    </ul>
	                    <ul class="pagination visible-xs pull-right">
	                        <li><a href="#">«</a></li>
	                        <li><a href="#">»</a></li>
	                    </ul>
	                  </div>
	                </div>
              </div>
  	</div>
  	</div>
  	<!-- Modal -->
    <jsp:include page="modalForm.jsp"/>
</div>
 
<script type="text/javascript">
	function openModelWithParam(titleCustomer, scheduledDate, lastname, firstname,  idTask , notes) {
	
		$('[name=titleCustomer] option').filter(function() { 
		    return ($(this).text() == titleCustomer); 
		}).prop('selected', true);
		
		$('input#scheduledDate').val(scheduledDate);
		$('input#firstname').val(firstname);
		$('input#lastname').val(lastname);
	   
		$('input#idTask').val(idTask);
		$("#notes").html(notes);
		
		

		$('#myModal').modal('show');
	 }
	
	
	
	 
</script>


<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/js/bootstrap-datetimepicker.min.js'></script>
<script src="resources/js/index.js"></script>
<jsp:include page="footer.jsp" />

</body>
</html>