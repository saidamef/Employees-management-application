<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestionnaire d'entreprise</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Gestionnaire d'employé</h1>
    <h2>
        <a href="http://localhost:7800/Employees/EmployeeForm.jsp">Ajouter nouvel employé</a>
        &nbsp;&nbsp;&nbsp;
        <a href="http://localhost:7800/Employees/">Afficher tous les employés</a>

    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List des employés</h2></caption>
        <tr>
            <th>Matricule</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Département</th>
        </tr>
        <c:forEach var="employee" items="${listEmployee}">
            <tr>
                <td><c:out value="${employee.matricule}" /></td>
                <td><c:out value="${employee.nom}" /></td>
                <td><c:out value="${employee.prénom}" /></td>
                <td><c:out value="${employee.département}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${employee.matricule}' />">Editer</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${employee.matricule}' />">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>