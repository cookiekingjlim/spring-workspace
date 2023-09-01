<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
<style>
    h1{
    margin-top: 70px;
    }
    .form-group{
    margin: 20px 0;
    }

</style>
</head>

<body>
    <div class="container">
        <h1>게시글 수정</h1>
        <form action="/board/update" method="post" enctype="multipart/form-data">
        <input type="hidden" name="no" id="no" value="${vo.no}">
        <input type="hidden" name="url" id="url" value="${vo.url}">
        
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" name="title" id="title" readonly value="${vo.title}" class="form-control">
            </div>
            <div class="form-group">
                <label for="content">Content</label>
                <textarea name="content" id="content" cols="30" rows="10" class="form-control" style="resize: none" readonly>${vo.content}</textarea>
            </div>
            <div class="form-group">
            	<label for="uploadFile">Add File</label>
            	<input class="form-control" type="file" id="uploadFile" name="uploadFile" accept="image/*">
            </div>
            <div class="form-group">
                <label for="writer">writer</label>
                <input type="text" name="writer" id="writer" readonly value="${vo.writer}" class="form-control">
            </div>
		
			<button type="submit" class="btn btn-outline-warning">수정</button>
        </form>

    </div>
</body>
</html>