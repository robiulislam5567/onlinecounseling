
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="col-md-6 col-md-offset-3">
	<sf:form method="post" class="form-horizontal"
		action="${pageContext.request.contextPath}/addnewuser"
		modelAttribute="userfrom">
		<fieldset>

			<!-- Form Name -->
			<legend>Create new Account</legend>

			<!-- Text input-->
			<div class="control-group">
				<label class="control-label" for="name">UserName</label>
				<div class="controls">
					<sf:input path="username" placeholder="enter username"
						class="input-xlarge" />
					<br />
					<sf:errors path="username" cssStyle="color:red"></sf:errors>
				</div>
			</div>
			<!-- password-->
			<div class="control-group">
				<label class="control-label" for="email">Password</label>
				<div class="controls">
					<sf:input id="password" name="password" path="password"
						placeholder="enter ur passwoed" class="input-xlarge"
						type="password" />
					<br />
					<sf:errors path="password" cssStyle="color:red"></sf:errors>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="email">Role</label>
				<div class="controls">
					
					<select name="authority">
					<option>ROLE_TEACHER</option>
					<option>ROLE_USER</option>
					</select>
				</div>
			</div>
			<!-- Text input-->
			<div class="control-group">
				<label class="control-label" for="email">Email</label>
				<div class="controls">
					<sf:input id="email" name="email" path="email"
						placeholder="enter valid email" class="input-xlarge" type="text" />
					<br />
					<sf:errors path="email" cssStyle="color:red"></sf:errors>
				</div>
			</div>

			<!-- Button -->
			<div class="control-group">
				<label class="control-label" for="submit"></label>
				<div class="controls">
					<button id="submit" name="submit" class="btn btn-primary">Add
						user</button>
				</div>
			</div>

		</fieldset>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</sf:form>
</div>
