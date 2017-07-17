<!DOCTYPE html>
<html lang="en">

<head>
  <title>Fantasy Football Draft</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
  <div class="container-fluid text-center">
    <div class="row">
      <h1>NFL Fantasy Football Draft</h1>
    </div>
    <div class="row">
      <h3>For 4 to 12 teams, 16 rounds</h3>
    </div>
    <br>
    <br>
    <div class="row">
      <input type="button" id="new-draft-button" class="btn btn-primary center-block" value="Click here to start a new draft" 
      onclick="window.location.href='newDraft'; return false;" />
    </div>
  </div>
</body>

</html>