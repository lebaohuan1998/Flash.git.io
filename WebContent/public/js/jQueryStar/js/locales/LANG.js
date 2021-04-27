/*!
 * Star Rating <LANG> Translations
 *
 * This file must be loaded after 'star-rating.js'. Patterns in braces '{}', or
 * any HTML markup tags in the messages must not be converted or translated.
 *
 * NOTE: this file must be saved in UTF-8 encoding.
 *
 * @see http://github.com/kartik-v/bootstrap-star-rating
 * @author Kartik Visweswaran <kartikv2@gmail.com>
 */
(function ($) {
    "use strict";
    $.fn.ratingLocales['<LANG>'] = {
        defaultCaption: '{rating} Stars',
        starCaptions: {
            0.5: 'Half Star',
            1: 'Dở Tệ',
            1.5: 'One & Half Star',
            2: 'Dở',
            2.5: 'Two & Half Stars',
            3: 'Bình Thường',
            3.5: 'Three & Half Stars',
            4: 'Khá',
            4.5: 'Four & Half Stars',
            5: 'Tốt'
        },
        clearButtonTitle: 'Clear',
        clearCaption: 'Not Rated'
    };
})(window.jQuery);
