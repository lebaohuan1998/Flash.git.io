/*----con chỏ cuộn--*/
$(document).ready(function () {
  $('.menu #a').click(function (event) {
    event.preventDefault();

    part = $(this).attr('href'); // lấy id của thẻ h2 tương ứng

    position = $(part).offset().top; // tìm vị trí thẻ h2

    $('html, body').animate({ scrollTop: position }, 600, 'easeInOutSine');
  });
});

/*--- action to top---*/
jQuery(document).ready(function($){ 	
	if($(".btn-top").length > 0){
		$(window).scroll(function () {
			var e = $(window).scrollTop();
			if (e > 300) {
				$(".btn-top").show()
			} else {
				$(".btn-top").hide()
			}
		});
		$(".btn-top").click(function () {
			$('body,html').animate({
				scrollTop: 0
			},600,'easeInOutSine')
		})
	}		
});
