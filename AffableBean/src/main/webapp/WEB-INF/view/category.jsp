<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%--<sql:query var="categories" dataSource="jdbc/affableMySqlDS">
    SELECT *  FROM category
</sql:query>--%>

<%--<sql:query var="selectedCategory" dataSource="jdbc/affableMySqlDS">
    SELECT name FROM category WHERE id = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query> 

<c:set var="categoryName" value="${selectedCategory.rows[0].name}"></c:set> --%>  

<%--<sql:query var="categoryProducts" dataSource="jdbc/affableMySqlDS">
    SELECT * FROM product WHERE category_id = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>--%>

<div id="categoryLeftColumn">
    <c:forEach var="category" items="${categories}">
        <%-- <c:out value="${category.id}"></c:out>
        <c:out value="${'aa'}"></c:out>
        <c:out value="${pageContext.request.queryString}"></c:out> --%>
        <c:choose>
            <c:when test="${category.name == selectedCategory.name}">
                <div class="categoryButton" id="selectedCategory">
                    <span class="categoryText">
                        ${category.name}
                    </span>
                </div>
            </c:when>
            <c:otherwise>
                <a href="category?${category.id}" class="categoryButton">
                    <span class="categoryText">
                        ${category.name}
                    </span>
                </a>
            </c:otherwise>
        </c:choose>

    </c:forEach>

</div>

<div id="categoryRightColumn">

    <p id="categoryTitle">${selectedCategory.name}</p>

    <table id="productTable">
        <c:forEach var="product" items="${categoryProducts}" varStatus="iter">    

            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                <td>
                    <img src="${initParam.productImagePath}${product.name}.png"
                         alt="${product.name}">
                </td>

                <td>
                    ${product.name}
                    <br>
                    <span class="smallText">${product.description}</span>
                </td>

                <td>&euro; ${product.price}</td>

                <td>
                    <form action="<c:url value='addToCart'/>" method="post">
                        <input type="hidden"
                               name="productId"
                               value="${product.id}">
                        <input type="submit"
                               name="submit"
                               value="add to cart">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>