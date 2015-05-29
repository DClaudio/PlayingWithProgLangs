(defun menu-item-name (data)
  (format nil "Menu Item ~D" data))
 
(defun submenu-item-name (data)
  (format nil "Submenu Item ~D" data))
 
(contain
 (make-instance
  'menu
  :items
  (list
   (make-instance 'menu-component
                  :items '(1 2)
                  :print-function 'menu-item-name
                  )
 
   (make-instance 'menu-component
                  :items
                  (list 3
                        (make-instance
 
                         'menu
                         :title "Submenu"
                         :items '(1 2 3)
                         :print-function
                         'submenu-item-name))
                  :print-function 'menu-item-name)
 
   (make-instance 'menu-item
                  :data 42))
  :print-function 'menu-item-name))