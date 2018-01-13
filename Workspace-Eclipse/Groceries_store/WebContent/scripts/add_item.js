/*
 * To add items into cart
 */
$(document).ready(
		function() {
			$(document).on(
					'click',
					'.button',
					function(e) {
						var label = $(this).val();
						if (label === 'Add') {
							var $input = $(this).closest('.holder').find(
									'.input');
							$input.closest('.modify').attr('style',
									'display:block');
							$input.attr('disabled', false);
							$(this).closest('.add').attr('style',
									'display:none');
							$('.submit').val(parseInt($('.submit').val()) + 1)
						} else if (label === '-') {
							var $input = $(this).closest('.modify').find(
									'.input');
							if ($input.val() != 1) {
								$input.val(parseInt($input.val()) - 1);
							} else {
								$('.submit').val(
										parseInt($('.submit').val()) - 1);
								var $input = $(this).closest('.holder').find(
										'.input');
								$input.closest('.modify').attr('style',
										'display:none');
								$input.attr('disabled', true);
								$(this).closest('.holder').find('.add').attr(
										'style', 'display:block');
							}
						} else {
							var $input = $(this).closest('.modify').find(
									'.input');
							$input.val(parseInt($input.val()) + 1);
						}
					})
		});