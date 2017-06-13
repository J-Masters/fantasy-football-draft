<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <title>Create Teams</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<form:form action="draft" modelAttribute="draft" method="POST">

  <p>Enter teams in order of first round pick.</p>
  <tr>
    <th>Team Name</th>
  </tr>
  <br>
  
  <c:forEach items="${draft.draftTeams}" var="team" varStatus="i">
    <tr>
      <td>
        <form:input path="draftTeams[${i.index}]" />
        <form:errors path="draftTeams" />
      </td>
    </tr>
    <br>
  </c:forEach>
  
  <input type="submit" value="Add teams and start draft" />
  
</form:form>

</body>


</html>