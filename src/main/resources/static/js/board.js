/**
 * 
 */

let index = {
    init: function() {
        $("#btn-board-save").on("click", ()=> { // ()=>{} this를 바인딩 하기 위해서
            this.save()
        });
        $("#btn-delete").on("click", ()=> { // ()=>{} this를 바인딩 하기 위해서
            let t = confirm("삭제 하시겠습니까?")
            if(t) this.deleteById()
        });
        $("#btn-update").on("click", ()=> { // ()=>{} this를 바인딩 하기 위해서
            this.updateById()
        });
        $("#btn-board-list").on("click", ()=> { // ()=>{} this를 바인딩 하기 위해서
            location.href = "/"
        });
        $("#btn-reply-save").on("click", ()=> { // ()=>{} this를 바인딩 하기 위해서
            this.replySave()
        });
    },
    save: function() {
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        }
        // alert("call save")
        console.log(data)
        $.ajax({
            type: "POST",
            url: "/api/board", 
            data: JSON.stringify(data), // http body
            contentType:"application/json; charset=utf-8", // body가 어떤 타입인지
            dataType: "json" // 응답 결과의 타입(기본적으로 문자열인데 생긴게 json이라면) => javascript 
        }).done(function(response) {
            // 정상
            alert("글쓰기가 완료되었습니다.")
            console.log(response)
            location.href = "/"
        }).fail(function(error) {
            // 실패
            alert("fail : \n" + JSON.stringify(error))
        });
    },
    deleteById: function() {
        let id = $("#id").text();
        
        console.log("id ", id)
        $.ajax({
            type: "DELETE",
            url: "/api/board/"+id, 
            dataType: "json" // 응답 결과의 타입(기본적으로 문자열인데 생긴게 json이라면) => javascript 
        }).done(function(response) {
            // 정상
            alert("삭제가 완료되었습니다.")
            console.log(response)
            location.href = "/"
        }).fail(function(error) {
            // 실패
            alert("fail : \n" + JSON.stringify(error))
        });
    },
    updateById: function() {
        let id = $("#id").val();
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        }
        console.log("updateById id ", id)
        console.log("updateById data ", data)
        $.ajax({
            type: "PUT",
            url: "/api/board/"+id, 
            data: JSON.stringify(data), // http body
            contentType:"application/json; charset=utf-8", // body가 어떤 타입인지
            dataType: "json" // 응답 결과의 타입(기본적으로 문자열인데 생긴게 json이라면) => javascript 
        }).done(function(response) {
            // 정상
            alert("수정이 완료되었습니다.")
            console.log(response)
            location.href = "/"
        }).fail(function(error) {
            // 실패
            alert("fail : \n" + JSON.stringify(error))
        });
    },
    replySave: function() {
        let data = {
            userId: $("#userId").val(),
            boardId: $("#boardId").val(),
            content: $("#reply-content").val()
        }
        
        //let boardId = $("#boardId").val();
        // alert("call save")
        console.log("replySave data : ", data)
        $.ajax({
            type: "POST",
            url: `/api/board/${data.boardId}/reply`, 
            data: JSON.stringify(data), // http body
            contentType:"application/json; charset=utf-8", // body가 어떤 타입인지
            dataType: "json" // 응답 결과의 타입(기본적으로 문자열인데 생긴게 json이라면) => javascript 
        }).done(function(response) {
            // 정상
            alert("댓글 작성이 완료되었습니다.")
            console.log(response)
            location.href = `/board/${data.boardId}`
        }).fail(function(error) {
            // 실패
            alert("fail : \n" + JSON.stringify(error))
        });
    },
    replyDelete: function(boardId, replyId) {
        console.log("replyDelete boradId : ", boardId)
        console.log("replyDelete replyId : ", replyId)
        alert(`/api/board/${boardId}/reply/${replyId}`);
        $.ajax({ 
            type: "DELETE",
            url: `/api/board/${boardId}/reply/${replyId}`,
            dataType: "json"
        }).done(function(resp){
            alert("댓글삭제 성공");
            location.href = `/board/${boardId}`;
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
}

index.init()