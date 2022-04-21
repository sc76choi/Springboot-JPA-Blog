/**
 * 
 */

let index = {
    init: function() {
        $("#btn-save").on("click", () => { // ()=>{} this를 바인딩 하기 위해서
            this.save()
        });
    },
    save: function() {
        // alert("call save")
        let data = {
            username: $("#userName").val(),
            password: $("#password").val(),
            email: $("#email").val(),
        }
        //console.log(data)
        //alert(data)
        
        // ajax 통신을 이용해서 3개의 파라미터를 json으로 변경하여 insert 요청
        // ajax 호출시 default가 비동기 호출
        $.ajax({
            // 회원가입 수행
            type: "POST",
            url: "/api/user/join"
        }).done(function() {
            // 정상
        }).fail(fucntion() {
            // 실패
        });
    }
}

index.init()