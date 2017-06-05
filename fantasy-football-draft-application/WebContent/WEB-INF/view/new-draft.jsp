<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <title>Create a New Draft</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

	<form:form action="startNewDraft" modelAttribute="draft">

		<p>What type of draft?</p>
		<form:select path="draftType">
			<form:options items="${draft.draftTypeOptions}" />
		</form:select>
		
		<br>
		
		<p>How many teams will there be?</p>
		<form:input path="numTeams" />
		<form:errors path="numTeams" />
		
		<br>
		<br>
		
		<input type="submit" value="Next" />

	</form:form>

</body>

</html>