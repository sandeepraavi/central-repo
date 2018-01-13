/**
 * For Register and Login forms
 */
$(document).ready(function() {
	
	setTimeout(
			  function() 
			  {
				  $("input, textarea").each(function(index) {
						var $this = $(this), label = $this.prev('label');
						if ($this.val() === '') {
							label.removeClass('active highlight');
						} else {
							label.addClass('active highlight');
						}
					});
			  }, 900);
	
	 
	$('.form').find('input, textarea').on('keydown keyup focus', function(e) {
		var $this = $(this), label = $this.prev('label');
		if ($this.val() === '') {
			label.removeClass('active highlight');
		} else {
			label.addClass('active highlight');
		}
	});

	$('.form').find('input, textarea').on('blur', function(e) {
		var $this = $(this), label = $this.prev('label');
		if ($this.val() === '') {
			label.removeClass('active highlight');
		} else {
			label.addClass('active highlight');
		}
	});

	$('.tab a').on('click', function(e) {
		e.preventDefault();
		$(this).parent().addClass('active');
		$(this).parent().siblings().removeClass('active');
		target = $(this).attr('href');
		$('.tab-content > div').not(target).hide();
		$(target).slideDown(500);
	});
});