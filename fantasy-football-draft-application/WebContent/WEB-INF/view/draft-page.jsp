<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <title>Draft</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container-fluid draft-content">
  <div class="row row-centered">
    <c:forEach var="team" items="${draft.draftTeams}">
      <div id="team-box" class="white col-md-1 col-centered"><c:out value="${team}" /></div>
    </c:forEach>
  </div>

  <!-- 16 is the standard number of rounds -->
  <c:forEach var="round" begin="1" end="16">
    <div class="row row-centered pick-row">
      <c:forEach var="pick" begin="1" end="${draft.numTeams}">

        <c:choose>
          <c:when test="${draft.draftType == 'Linear' || draft.draftType == 'Snake' && round % 2 == 1 || draft.draftType == 'Reverse Snake' && draft.fwdRounds.contains(round)}">
            <c:set var="currentPick" value="${draft.numTeams * (round - 1) + pick}" />
          </c:when>
          <c:otherwise>
            <c:set var="currentPick" value="${draft.numTeams * round + (numTeams - pick + 1)}" />
          </c:otherwise>
        </c:choose>
      
      <c:set var="pickUsed" value="${false}" />
      <c:forEach var="player" items="${draft.draftedPlayers}">
        <c:if test="${player.pick == currentPick}">
          <div id="pick-box" class="white col-md-1 col-centered">
              <p id="pick-line"><c:out value="${player.pick}" /></p>
              <p id="pick-line"><c:out value="${player.playerName}" /></p>
              <p id="pick-line"><c:out value="${player.position}" /></p>
              <p id="pick-line"><c:out value="${player.nflTeam}" /></p>
          </div>
          <c:set var="pickUsed" value="${true}" />
        </c:if>
      </c:forEach>
      
      <c:if test="${pickUsed == false}">
        <div id="pick-box" class="white col-xs-1 col-centered"><c:out value="${currentPick}" /></div>
      </c:if> 
      </c:forEach>
    </div>
  </c:forEach>
</div>

<div class="footer">
  <div class="row">
    <form:form action="assignPlayer" modelAttribute="draft">
      <div class="col-md-3 col-md-offset-3">
        <form:select size="10" class="selectpicker player-selection" path="selectedPlayerName">
          <form:options items="${draft.availablePlayers}" />
        </form:select>
      </div>
      <div class="col-md-2 col-md-offset-1">
        <input type="submit" id="submit-pick-button" class="btn btn-primary" value="Submit Pick" />
      </div>
    </form:form>
  </div>
</div>
 
</body>
</html>









