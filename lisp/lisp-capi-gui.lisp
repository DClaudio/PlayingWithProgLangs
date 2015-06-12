;create a test callback and hello function

(defun test-callback (data interface)
  (display-message "Data ~S in interface ~S"
                   data interface))
(defun hello (data interface)
  (declare (ignore data interface))
  (display-message "Hello World"))
;create the CAPI interface with a menu Foo which contains four items
(make-instance 'menu
    :title "Foo"
    :items '("One" "Two" "Three" "Four")
    :callback 'test-callback)
 
(make-instance 'interface
    :menu-bar-items (list *))
 
(display *)

;; create a submenu by specifying a menu as one of the items of the top-level menu
(make-instance 'menu
    :title "Bar"
    :items '("One" "Two" "Three" "Four")
    :callback 'test-callback)
 
(make-instance 'menu
    :title "Baz"
    :items (list 1 2 * 4 5)
    :callback 'test-callback)
 
(contain *)

;; this is an example of a menu-component class that lets you grou related items together
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


;;RADIO buttons
(setq radio (make-instance 'menu-component
                :interaction :single-selection
                :items '("This" "That")
                :callback 'hello))
 
(setq commands (make-instance 'menu
                :title "Commands"
                :items
                 (list "Command 1" radio "Command 2")
                :callback 'test-callback))
 
(contain commands)

;;Checed menu
(setq letters (make-instance 'menu-component
                  :interaction :multiple-selection
                  :items (list "Alpha" "Beta")))
(contain (make-instance 'menu
                  :title "Greek"
                  :items (list letters)
                  :callback 'test-callback))
