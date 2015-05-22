
#!/c/prj/perl
use warnings;
use strict;
use Data::Dumper;

#-----------------iNTRODUCTION-----------------------
print "hellow World \n";
my $name = 'cla';
my $greeting = "hello, $name\n";
print $greeting;
#use of qw() function
my ($first,$last)=qw( John Doe );
print "first is '$first'\n";
print "last is '$last'\n";
#use of chomp
my $string = "hello world\n";
chomp($string);
warn "string is '$string' \n";



#-------------------------GENRAL STRING FUNCTIONS---------------

my $fullname = 'mud' . 'bath'; #concatenation
my $line = '-' x 50; #repetition;
print "$line\n";
my $len = length($line);
my $string2 = 'the rain in spain';
#substring
print substr($string2, 9, 2)."\n";
substr($string2 , 9, 2) = 'beyond';
print "$string2 \n";
#split
my $tab_sep_data = "John\tDoe\tmale\t42";
my ($firstName,$lastname,$gender,$age)= split(/\t/, $tab_sep_data);


#---------------------DATA TYPES-------------------
# $scalars @arays and %hashes
my @numbers = qw ( zero one two three );
my $arrayelement = $numbers[2];
my $arrayLength = scalar(@numbers);
print $arrayLength;
#add elements to arrayLength
push(@numbers, qw ( four five ));
print Dumper \@numbers;
#iterate over arrays
foreach my $number (@numbers){
	print "number is $number\n";
}
#sort arrays 
my @fruit = qw ( pears apples bananas oranges );
my @sorted_array = sort(@fruit); #sorts the array alphabetically even for numbers
print Dumper \@sorted_array ;
my @scores = ( 1000, 13, 27, 200, 76, 150 );
my @sorted_array = sort {$a<=>$b} (@scores); #sorts array ascending 
#has declaration
my %info = qw ( name John age 42 );
my $data = $info{name};
print $data."\n";
my %pets = (cats => 2, dogs => 1);
unless(exists($pets{fish})){
	print "no fish here\n";
}
#complex data structures
my %pets = (fish =>3, cats=>2, dogs=>1);
my @refrigirator = qw(milk bread eggs);
my $house = { pets => \%pets,
					   refrigirator => \@refrigirator
					   };
print Dumper $house;