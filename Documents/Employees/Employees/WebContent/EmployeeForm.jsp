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
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="http://localhost:7800/Employees/EmployeeList.jsp">Afficher tous les employés</a>

    </h2>
</div>
<div align="center">
    <c:if test="${employee != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${employee == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${employee != null}">
                            Editer employé
                        </c:if>
                        <c:if test="${employee == null}">
                            Ajouter nouvel employé
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${employee != null}">
                    <input type="hidden" name="matricule" value="<c:out value='${employee.matricule}' />" />
                </c:if>
                <tr>
                    <th>Nom: </th>
                    <td>
                        <input type="text" name="Nom" size="45"
                               value="<c:out value='${employee.nom}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Prénom: </th>
                    <td>
                        <input type="text" name="Prénom" size="45"
                               value="<c:out value='${employee.prénom}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Département: </th>
                    <td>
                        <input type="text" name="Département" size="5"
                               value="<c:out value='${employee.département}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="submit" value="Submit" onclick="form. submit()" autofocus="autofocus"/>
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>