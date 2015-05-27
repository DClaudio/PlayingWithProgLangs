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


;Lisp lambda functions
((lambda (a b c n)
	(+ (* a (* n n) ) (* b n)))
	1 3 5 7)
	
; LISP macros can be anything from an abbreviation to a compiler for a new language
; A macro has to return a form to be evaluated not a value
(defmacro setq-literal (place literal)
	`(setq, place ', literal))
(defmacro reverse-cons (rest first)
	`(cons, first, rest)) 

; macroexpand will apply the macro to its arguments to produce the object code - useful for debuging
(macroexpand '(setq-literal a b))

; This macro encloses function arguments inside a coll to the special function
; TODO: determine how to call this function
(defmacro flambda (&rest l)
	(list 'function (cons 'lambda l)))
(macroexpand '(flambda (x y) (cons y x))) ;prints out the following: (FUNCTION (LAMBDA (X Y) (CONS Y X)))
((flambda (x y) (cons y x)) 3 4) ;this is not the right way

;the macro pop
(defmacro example-pop (stack)
	(list 'prog1 
		(list 'car stack)
			(list 'setq stack (list 'cdr stack))))
;Execution example 			
#|
> (setq stack '(a b c))
(A B C) 
> (example-pop stack)
A 
> stack
(B C)
|#

;; LISP clojures
(defun generate-even (*evenum*)
	(function 
		(lambda()
			(setq *evenum* (+ *evenum* 2)))))

(setq gen-even-1 (generate-even 0))

(defun generate-even-odd (*seed*)
    (list
        (function
            (lambda()
                (setq *seed* (cond ((evenp *seed*) (+ *seed* 2))
                    (t (1+ *seed*))))))
 
         (function
             (lambda()
                 (setq *seed* (cond ((oddp *seed*) (+ *seed* 2))
                     (t (1+ *seed*))))))))
(setq fns (generate-even-odd 0))
		

;Some macros again
(defmacro defsynonym (old-name new-name)
			"Define OLD-NAME to be equivalent to NEW-NAME  when used in the first position of a Lisp form."
			`(defmacro ,new-name (&rest args)
					`(, `,old-name, @args)))


#|
Object-oriented programming in Common Lisp - CLOS

1. Layered system designed for flexibility - foundted on the meta-object protocol
	- first level provides a programmatic interface to the object-oriented programming ;
	- 2nd layer provides a functional interface into the heart of the Object System ->for very complex software problems;
	- 3rd layer iprovides the tools for writing your own object-oriented language;
	
2. Based on the concept of generic functions rather than on message passing 

3. Multiple inheritance 

4. Powerful method combination facility

5. The primary entities of the system are all first-class objects


|#
	
	
;Classes
(defclass position () ())
(defclass x-y-position (position)
      ((x :initform 0)
       (y :initform 0))
     (:accessor-prefix position-))
