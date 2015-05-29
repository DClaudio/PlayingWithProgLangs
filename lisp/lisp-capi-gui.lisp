(defun test-callback (data interface)
  (display-message "Data ~S in interface ~S"
                   data interface))
(defun hello (data interface)
  (declare (ignore data interface))
  (display-message "Hellow World"))
(make-instance 'menu
               :title "Foo"
               :items '("One" "Two" "Three" "Four")
               :callback 'test-callback)
(make-instance 'interface
               :menu-bar-items (list*))
(display *)

(make-instance 'menu
    :title "Bar"
    :items '("One" "Two" "Three" "Four")
    :callback 'test-callback)
(make-instance 'menu
    :title "Baz"
    :items (list 1 2 * 4 5)
    :callback 'test-callback)
 
(contain *)
(setq component (make-instance 'menu-component
                     :items '("item 1" "item2")
                     :print-function 'string-capitalize
                     :callback 'test-callback))
 
(contain (make-instance 'menu
                        :title "Items"
                        :items
                        (list "menu 1" component "menu 2")
                        :print-function 'string-capitalize
                        :callback 'hello)
         :width 150
         :height 0)