<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <title>Draft</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
  <table>
    <tr>
	  <c:forEach var="team" items="${draft.draftTeams}">
	    <th>${team}</th>
	  </c:forEach>
    </tr>

    <!-- 16 is the standard number of rounds -->
    <c:forEach var="round" begin="1" end="16">
      <tr>
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
          <td class="pickBox">
            <ul>
              <li><c:out value="${player.pick}" /></li>
              <li><c:out value="${player.playerName}" /></li>
              <li><c:out value="${player.position}" /></li>
              <li><c:out value="${player.nflTeam}" /></li>
            </ul>
          </td>
          <c:set var="pickUsed" value="${true}" />
        </c:if>
      </c:forEach>
      <c:if test="${pickUsed == false}">
        <td class="pickBox"><c:out value="${currentPick}" /></td>
      </c:if> 
      
      </c:forEach>
      </tr>
      <br>
    </c:forEach>
  </table>
  
  <form:form action="assignPlayer" modelAttribute="draft">
    <form:select size="5" path="selectedPlayerName">
      <form:options items="${draft.availablePlayers}" />
    </form:select>
    <br>
    <input type="submit" value="Submit Pick" />
  </form:form>
  
</body>
</html>









