<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <title>Create Teams</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="text-center">
  <h2>Fantasy Team Names</h2>
  <br>
  <form:form action="draft" modelAttribute="draft" method="POST">

    <p>Enter teams in order of first round pick.</p>
    <br>
  
    <c:forEach items="${draft.draftTeams}" var="team" varStatus="i">
      <tr>
        <td>
          <div class="col-md-2 centered">
            <form:input class="form-control blue-background" path="draftTeams[${i.index}]" />
            <form:errors path="draftTeams" />
          </div>
        </td>
      </tr>
      <br>
    </c:forEach>
    <br>
    <input type="submit" class="btn btn-primary centered double-font-size" value="Add teams and start draft" />
  </form:form>

</div>
</body>

</html>