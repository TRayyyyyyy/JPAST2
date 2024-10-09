<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<form action="<c:url value='/admin/video/update'></c:url>" method="post" enctype="multipart/form-data">
    <fieldset>
    <legend>Edit Video</legend>
        <label for="videoFile">Choose file:</label><br>

	        <c:if test="${video.poster.substring(0,5) != 'https' }">
	            <c:url value="/video?fname=${video.poster}" var="imgUrl"></c:url>
	        </c:if>
	        
	        <c:if test="${video.poster.substring(0,5) == 'https' }">
	            <c:url value="${video.poster}" var="imgUrl"></c:url>
	        </c:if>
        
        <img id="poster" height="150" width="200" src="${imgUrl}" />
        <input type="file" onchange="chooseFile(this)" id="poster" name="Poster" ><br><br>
        
        
        <label for="videoId">Video ID:</label>
        <input type="text" id="videoId" name="VideoId" value="${video.videoid}" readonly><br><br>
       
        <label for="videoTitle">Title:</label>
        <input type="text" id="videoTitle" name="Title" value="${video.title}"><br><br>

        <label for="videoDescription">Description:</label><br>
        <textarea id="videoDescription" name="Description" rows="4" cols="50">${video.description}</textarea><br><br>

        <label for="viewCount">View Count:</label>
        <input type="number" id="viewCount" name="Views" value="${video.views}" readonly><br><br>

        <label for="category">Category:</label>
        <select id="category" name="categoryid">
            <c:forEach var="category" items="${categories}">
                <option value="${category.categoryid}" ${category.categoryid == video.category.categoryid ? 'selected' : ''}>${category.categoryname}</option>
            </c:forEach>
        </select><br><br>

        <label>Active:</label><br>
        <input type="radio" id="active" name="Active" value="1" ${video.active == 1 ? 'checked' : ''}>
        <label for="active">Hoạt động</label><br>
        <input type="radio" id="inactive" name="Active" value="0" ${video.active == 0 ? 'checked' : ''}>
        <label for="inactive">Khóa</label><br><br>

        <input type="submit" value="Update">
    </fieldset>
</form>
