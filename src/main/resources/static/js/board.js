/**
 * 
 */

let index = {
    init: function() {
        $("#btn-board-save").on("click", ()=> { // ()=>{} this를 바인딩 하기 위해서
            this.save()
        });
        $("#btn-delete").on("click", ()=> { // ()=>{} this를 바인딩 하기 위해서
            this.deleteById()
        });
        $("#btn-update").on("click", ()=> { // ()=>{} this를 바인딩 하기 위해서
            this.updateById()
        });
        $("#btn-board-list").on("click", ()=> { // ()=>{} this를 바인딩 하기 위해서
            location.href = "/"
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
}

index.init()