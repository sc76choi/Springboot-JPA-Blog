/**
 * 
 */

let index = {
    init: function() {
        $("#btn-save").on("click", ()=> { // ()=>{} this를 바인딩 하기 위해서
            this.save()
        });
    },
    save: function() {
        let data = {
            userName: $("#userName").val(),
            password: $("#password").val(),
            email: $("#email").val(),
        }
        //alert("call save")
        console.log(data)
        //alert(data)
        
        // ajax 통신을 이용해서 3개의 파라미터를 json으로 변경하여 insert 요청
        // ajax 호출시 default가 비동기 호출
        // ajax가 통신을 성공하고, json을 리턴해 주면, 자동으로 java 오브젝트로 변환
        $.ajax({
            // 회원가입 수행
            type: "POST",
            url: "/blog/api/user",
            data: JSON.stringify(data), // http body
            contentType:"application/json; charset=utf-8", // body가 어떤 타입인지
            dataType: "json" // 응답 결과의 타입(기본적으로 문자열인데 생긴게 json이라면) => javascript 
        }).done(function(response) {
            // 정상
            alert("회원가입이 완료되었습니다.")
            console.log(response)
            location.href = "/blog"
        }).fail(function(error) {
            // 실패
            alert(JSON.stringify(error))
        });
    }
}

index.init()