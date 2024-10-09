<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<form action="<c:url value='/admin/video/insert'></c:url>" method="post" enctype="multipart/form-data">
    <fieldset>
        <legend>Upload Video</legend>
        
        <label for="videoFile">Choose file:</label>
		<input type="file" onchange = "chooseFile(this)" id="poster" name="Poster" accept="video/*"><br><br>
       
        <label for="videoId">Video ID:</label>
        <input type="text" id="videoId" name="VideoId"><br><br>
       
        <label for="videoTitle">Title:</label>
        <input type="text" id="videoTitle" name="Title"><br><br>

        <label for="videoDescription">Description:</label><br>
        <textarea id="videoDescription" name="Description" rows="4" cols="50"></textarea><br><br>

        <label for="viewCount">View Count:</label>
        <input type="number" id="viewCount" name="Views" value="0" readonly><br><br>

        <label for="category">Category:</label>
        <select id="category" name="categoryid"> 
            <c:forEach var="category" items="${categories}">
                <option value="${category.categoryid}">${category.categoryname}</option>
            </c:forEach>
        </select><br><br>

        <label>Active:</label><br>
        <input type="radio" id="active" name="Active" value="1" checked>
        <label for="active">Hoạt động</label><br>
        <input type="radio" id="inactive" name="Active" value="0">
        <label for="inactive">Khóa</label><br><br>

        <input type="submit" value="Create">
        <input type="submit" value="Update">
        <input type="submit" value="Delete">
        <input type="reset" value="Reset">
    </fieldset>
</form>
