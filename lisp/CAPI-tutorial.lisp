(defpackage "MY-PACKAGE"
	(:add-use-defaults t)
	(:use "CAPI")
)

(in-package my-package)

(setq interface
      (make-instance 'interface
                     :visible-min-width 200
                     :title "My Interface"))
 
(setq push-button
      (make-instance 'push-button
                     :data "Hello"
                     :callback 
                     #'(lambda (&rest args)
                         (display-message "Hello World"))))


