<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="modal fade" id="myModal" role="dialog">
  <div class="container">
   <form:errors path="*" cssClass="errorblock" element="div" />
  	<spring:url value="/saveTask" var="taskActionUrl" />
    	<form:form  method="post" action="saveTask" commandName="task"  cssClass="form-horizontal" >
  	     <div class="modal-dialog modal-lg">
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Modal Header</h4>
	           <form:hidden path="idTask"  id="idTask"/>
	        </div>
	        <div class="modal-body">
		        <div class="form-group">
				      <label class="col-sm-2 control-label" for="titleCustomer"><spring:message code="lbl.titleCustomer" />:</label>
				      <div class="col-sm-10">
				             <form:select path="titleCustomer" cssClass="form-control" id="titleCustomer">
						        <form:option class="form-control" value="NONE" label="--- Select ---" />
								<form:options class="form-control" items="${titlePersons}" />
							</form:select>
							<form:errors path="titleCustomer" cssClass="error" />
				      </div>
				 </div>
	        	<div class="form-group">
			      <label class="col-sm-2 control-label" for="firstname"><spring:message code="lbl.firstName" />:</label>
			      <div class="col-sm-10">
			        <form:input type="text" cssClass="form-control" id="firstname"  placeholder="Enter First Name of customer" path="firstname"/>
			        <form:errors path="firstname" cssClass="error" />
			      </div>
			    </div>
			    <div class="form-group">
			      <label class="col-sm-2 control-label" for="lastname"><spring:message code="lbl.lastName" />:</label>
			      <div class="col-sm-10">
			      	<form:input type="text" cssClass="form-control" id="lastname"   placeholder="Enter Last Name of customer" path="lastname"/>
			      	<form:errors path="lastname" cssClass="error" />
			      </div>
			    </div>
			    <div class="form-group">
		         <label class="col-sm-2 control-label" for="scheduledDate"><spring:message code="lbl.scheduledDate" />:</label>
                    <div class="col-sm-10">
                       <div class="input-group date" id="scheduledDate" >
	                      <form:input  type="text" cssClass="form-control" id="scheduledDate" placeholder="MM/DD/YYYY" path="scheduledDate" />
	                      <span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
	                     </span>
	                     <form:errors path="scheduledDate" cssClass="error" />
	                  </div>
		      	  </div>
	          	</div>  
			    <div class="form-group">
			       <label class="col-sm-2 control-label" for=notes><spring:message code="lbl.notes" />:</label>
				   <div class="col-sm-10">
				  	<form:textarea cssClass="form-control" rows="5" id="notes" path="notes" placeholder="Enter notes of customer" ></form:textarea>
				  </div>
				</div>
	        </div>
	        <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="submit" class="btn btn-primary" ><spring:message code="lbl.save" /></button>
		      </div>
	      </div>
	    </div>
    </form:form>
  </div>
  </div>