	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<h1>Enter Your Todo Details here:</h1>
		<form:form method="POST" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:label path="description">Description:</form:label>
				<form:input type="text" path="description" name="description" required="required"/>
				<form:errors type="text" path="description" cssClass="text-warning"/>
			</fieldset>
			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date:</form:label>
				<form:input type="text" path="targetDate" name="targetDate" required="required"/>
				<form:errors type="text" path="targetDate" cssClass="text-warning"/>
			</fieldset>
			
			<form:input type="hidden" path="id" name="id" />
			<form:input type="hidden" path="done" name="done" />
			<input type="submit" class="btn btn-success">
		</form:form>
	</div>
	<%@ include file="common/footer.jspf" %>
	<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd',
	    startDate: '-3d'
	});
	</script>