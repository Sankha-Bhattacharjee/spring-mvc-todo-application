	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<div>Welcome ${ userName } to the welcome page!</div>
		<hr>
		<%-- 	<div>Name: ${ userName } Password: ${userPassword }</div> --%>
		<div>
			<a href="list-todos">Manage</a> your todos
		</div>
	</div>
<%@ include file="common/footer.jspf" %>