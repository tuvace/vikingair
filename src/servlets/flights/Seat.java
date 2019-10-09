package servlets.flights;
import java.util.Scanner;

public class Seat {

        boolean[] seating = new boolean[11]; //*lager 10 seter, der et ledig setet blir indikert ved false.*//
        Scanner input = new Scanner(System.in);

        public void start()
        {
            while ( true )
            {
                makeReservation();
            }
        }

        public void makeReservation()
        {
            System.out.println("For førsteklasse skriv inn tallet 1, for økonomiklasse skriv inn tallet 2:");
            int section = input.nextInt();
            if ( section == 1 )
            {
                firstClassSeat();
            }
            else
            {
                economySeat();
            }
        }

        public void firstClassSeat() //*Tildeles ett sete i førsteklasse
        {
            for ( int count = 1; count <= 5; count++ )
            {
                if ( seating[count] == false )  //* hvis false, er setet ledig
                {
                    seating[count] = true;  // assign seat
                    System.out.printf("Førsteklasse. Sete# %d\n", count);
                    break;
                }
                else if ( seating[5] == true ) // Hvis 5 seter er true, betyr det at hele førsteklasse er full.
                {
                    if ( seating[10] == true) // Hvis 10 seter er true er økonmi, og derfor hele flyet fult.
                    {
                        System.out.println("Det er dessverre ingen ledige plasser igjen på denne flyvningen, kanskje økonomiklasse har ledige plasser?.");
                    }
                }
            }
        }

        public void economySeat() // assign an economy seat
        {
            for ( int count = 6; count <= 10; count++ )
            {
                if ( seating[count] == false ) // if false, then a seat is available for assignment
                {
                    seating[count] = true; // assign seat
                    System.out.printf("Economy. Seat# %d\n", count);
                    break;
                }
                else if ( seating[10] == true ) // If seating[10] is true then economy is fully booked
                {
                    if ( seating[5] == true) // If seating[5] is true then first class (and therefore whole flight) is fully booked
                    {
                        System.out.println("Det er dessverre ingen ledige plasser igjen på denne flyvningen, kanskje førsteklasse har noen ledige seter?");
                        System.exit(0);
                    }
                }
            }
        }
    }

