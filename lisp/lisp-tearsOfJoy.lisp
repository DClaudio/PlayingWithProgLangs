;-------------------------------------------------
;LISP -Tears of Joy
;-------------------------------------------------
(/ (* 4 5) (+ 2 3))


;Define local variables
(let ( (x 18)
		(y 13)
		(z 15))
	(+ x y z))
	
;Defining a function
(flet ( (foo(n)
					(+ n 5))
		  (bar(n)
					( +n 10)))
	(bar (foo 2)))
	
;Defining recursive functions

(labels ( (foo(n)
				(+ n 5))
		  (bar (n)
				(+ (foo 2) n)))
	(bar 10))
		
;Defining a recursive function
(defun fac(n)
	(if (= n 0) 1
		(* n (fac (- n 1)))))

;Looping construct
(defun fac(n)
	(let ( (result 1))
		(dotimes (i n)
			(setq result (* result (+ i 1))))
		result))
		
;Object-oriented LISP
(defclass shape ()
   (x y))
 
(defclass rectangle (shape)
   ((width :initarg :width)
   (height :initarg :height)))
 
(defclass circle (shape)
   ((radius :initarg :radius)))
 
(defmethod area ((obj circle))
   (let ((r (slot-value obj 'radius)))
      (* pi r r)))
 
(defmethod area ((obj rectangle))
   (* (slot-value obj 'width)
      (slot-value obj 'height)))
;This is how you instantiate a RECTANGLE:
(setq my-rect (make-instance 'rectangle :width 3 :height 4))


;Quote feature - avoid evaluation of expressions
(quote (+ 7 2))
('(the list (+ 2 3 5) sums 3 elements)) ;Returns (THE LIST (+ 2 3 5) SUMS 3 ELEMENTS)
; this is used to create macros: programs that write programs




