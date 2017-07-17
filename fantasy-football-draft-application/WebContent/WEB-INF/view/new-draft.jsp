<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <title>Create a New Draft</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.3/css/bootstrap-select.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.3/js/bootstrap-select.min.js"></script>
</head>

<body>
  <div class="text-center">
    <h2>Draft Details</h2>
    <br>
	<form:form action="startNewDraft" modelAttribute="draft">

		<p>What type of draft?</p>
		<div class="col-md-2 centered">
		  <form:select class="selectpicker" path="draftType">
		    <option selected disabled>Select Draft Type</option>
			<form:options items="${draft.draftTypeOptions}" />
		  </form:select>
		</div>
		
		<br>
		<br>
		<br>
		
		<p>How many teams will there be?</p>
		<div class="col-md-1 centered">
		  <form:input class="form-control" path="numTeams" />
		</div>
		<form:errors path="numTeams" />
		
		<br>
		<br>
		
		<input type="submit" class="btn btn-primary double-font-size" value="Next" />

	</form:form>
  </div>
</body>

</html>