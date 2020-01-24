package com.example.manila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    EditText etName, etPassword;
    Button btnLogin;
    private DatabaseHelperForUsers mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etName = (EditText) findViewById(R.id.etLoginEmail);
        etPassword = (EditText) findViewById(R.id.etLoginPassword);
        if (getIntent().getBooleanExtra("LOGOUT", false)) {
            finish();
        }
    }
    public void onCLickBackStart(View view){
        startActivity(new Intent(this, Start.class));
    }
    public void login(View view) {
        if(etName.getText().toString().isEmpty()||etPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Fill all the TextField", Toast.LENGTH_SHORT).show();
            return;
        }
        mydb= new DatabaseHelperForUsers(this);
        Boolean check= mydb.CheckLogin(etName.getText().toString(),etPassword.getText().toString());
        if(check){
            mydb = new DatabaseHelperForUsers(view.getContext());
            Cursor res = mydb.getAllDataForLandmarks();
            if (res.getCount() == 0) {
                CreateData();
            }
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.putExtra("User", etName.getText().toString());
            startActivity(intent);
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "You fail to log in", Toast.LENGTH_SHORT).show();
        }


    }

    public void CreateData(){
        mydb.insertDataInLandmarks("National Planetarium","The National Museum has reopened the National Planetarium. It houses the Philippines’ Ethno astronomy, which shows how planets and stars have guided the country in sea navigation, agriculture, fishing and “the right timing of celebrating life ”. ", "Location: Dr. Jose P. Rizal Park, Padre Burgos Ave, Ermita  "," Entrance Fee: Free for the gallery, P40.00 for scheduled shows.  "," Open Hours: Open Tuesdays to Sundays ");
        mydb.insertDataInLandmarks("National Museum of Natural History","The majestic Tree of Life and 12 galleries highlight the rich biodiversity of the Philippines, putting it on par with the Amazon and Madagascar. ","Location: Teodoro F. Valencia Circle, Ermita P. Burgos Drive, Rizal Park  ","Entrance Fee: Free  "," Open Hours: Open Tuesdays to Sundays ");
        mydb.insertDataInLandmarks("National Museum of Anthropology","The former Museum of the Filipino People shows you what life was like from decades to centuries past. Check out the artefacts such as weapons, household tools, and musical instruments from different ethnicities. "," Location: Padre Burgos Ave, Ermita Manila. "," Entrance Fee: Free ","Open Hours: Open Tuesdays to Sundays ");
        mydb.insertDataInLandmarks("National Museum of Fine Arts","Housing the famous Spoliarium by Juan Luna, the museum also showcases works from the colonial Spanish period by Félix Resurreccion Hidalgo and Fernando Amorsolo. More contemporary paintings by Carlos “Botong” Francisco and Vicente Manansala are also on display. If you want to explore the country and its history through the eyes of its visual artists, the Fine Arts Museum is top priority. Housed in the old Congress building, it transports you to Manila’s boom pre-World War II. "," Location: Padre Burgos Ave, Ermita Manila. "," Entrance Fee: Free ","Open Hours: Open Tuesdays to Sundays");
        mydb.insertDataInLandmarks("Museo ni Jose Rizal","Rizal Shrine Museum is a two-storey building dedicated to the life and heroism of the Philippine national hero Dr. Jose Rizal. The building, which contained Rizal’s prison cell, originally housed the artillery companies of the Spanish army. The cell on the ground floor was the barracks pantry. Like the rest of the fort, it was destroyed during the World War II and was later reconstructed in 1953 to become the museum. "," Location: Fort Santiago, Intramuros, Manila "," Entrance Fee: P100 per person","Open Hours: Daily");
        mydb.insertDataInLandmarks("Intramuros, Fort Santiago","Fort Santiago was the governmental seat of power in Intramuros during the Spanish period. Hence, the most important details of history are etched in its structures—its dungeons, death chambers, prison cells, and Spanish offices. The highlight of the Fort Santiago, however, is the intellectual giant and martyr, Dr. Jose Rizal, whose novels and public execution sparked a revolution and ended the 333 years of Spanish regime. "," Location: Plaza Luis Complex, cor. A. Soriano Jr. Ave. and Gen. Luna St., Intramuros, City of Manila, Metro Manila "," Entrance Fee: P75 Regular, P50 Student "," Open Hours: Daily");
        mydb.insertDataInLandmarks("Rizal Park","Manila’s iconic central park is spread out over some 60 hectares of open lawns, ornamental gardens, ponds, paved walks and wooded areas, dotted with monuments to a whole pantheon of Filipino heroes. It's an atmospheric place to take a stroll, particularly late afternoon, early evening and on weekends. As the place where José Rizal was executed by the Spanish colonial authorities, it's also of great historical significance. "," Location:  Roxas Blvd, Malate, Manila, 1000 Metro Manila "," Entrance Fee: Free "," Open Hours: Daily");
        mydb.insertDataInLandmarks("Paco Park","Known as a place where visitors can catch traditional music concerts, Paco Park has also been a favorite wedding venue because of its garden ambiance. But even without the music and festivities, people can still enjoy some quiet time by taking a stroll around the circular park. The central feature of the grounds is the Chapel of St. Pancratius, but hidden on either side of the circle are places of honor for Jose Rizal and Gomburza (martyred priests Mariano Gomez Jose Burgos and Jacinto Zamora) "," Location: San Marcelino and General Luna Streets, Paco, Manila ","Entrance Fee: P5.00 "," Open Hours: Mondays to Sundays (except on Wednesdays) from 8 a.m. to 5 p.m.");
        mydb.insertDataInLandmarks("Manila Ocean Park","The Manila Ocean Park is one of the most unique adventures in the city. Get interactive with marine life with the Sharks and Rays Encounter, Trails to Antarctica, or the fish spa where fish clean your feet in a small pool of water. The park easily fills several hours depending on how many encounters you try. In addition to the state-of-the-art aquatic facility, you will see exhibits of birds and other animals. "," Location:  Manila Ocean Park Luneta, Manila","","");
        mydb.insertDataInLandmarks("San Agustin Church",": The church is in the resplendent Baroque style and needs a visit for its marvellous interior where trompe l’oeil paintings on the barrel vault and pilasters mimic pediments, reliefs, rosettes, laurels and other intricate mouldings. "," Location: General Luna St, Manila, 1002 Metro Manila","","");
        mydb.insertDataInLandmarks("Quiapo Church","The Quiapo Church is one of the oldest and most admired Catholic Churches in Manila. The more formal name of the church is the Minor Basilica of the Black Nazarene. Depending on the time of day, the plaza surrounding the century-old church can be quite congested, which makes it an interesting place to visit to admire the devotion of the Filipino people. Fridays are the busiest days, when thousands of people pile into the square and pray at the church for novena. ","Location: 363 Quezon Blvd, Quiapo, Manila, 1001 Metro Manila","","");
        mydb.insertDataInLandmarks("Manila Cathedral","The Minor Basilica and Metropolitan Cathedral of the Immaculate Conception (Filipino: Basilika Menore at Kalakhang Katedral ng Kalinis-linisang Paglilihi; Spanish: Basílica Menor y Catedral Metropolitana de la Inmaculada Concepción), also known as Manila Cathedral (Spanish: Catedral de Manila), is the cathedral of Manila and basilica located in Intramuros, the historic walled city within today's modern city of Manila, Philippines. It is dedicated to the Immaculate Conception, a title for the Blessed Virgin Mary, the principal patroness of the country. The cathedral serves as the episcopal see of the Archbishop of Manila. ","  Location:  Beaterio St, Cabildo St, Intramuros, Manila, 1002 Metro Manila","","");
        mydb.insertDataInLandmarks("China Town","Binondo, or popularly known as Manila’s Chinatown, is the oldest Chinatown in the world. Set on a hilly landscape, Binondo’s name was coined from the Tagalog word ‘binondoc’ which means mountainous when translated in English. While the site was originally created for Chinese immigrants who converted into Catholics, it has become one of the most-visited communities for the busy shopping streets of Escolta, and for being the center of authentic Chinese food such as Peking duck, century eggs, dumplings and other delights being served in numerous restaurants. "," Location: Binondo, Manila","","");
        mydb.insertDataInLandmarks("Divisoria","Divisoria is one big playground for bargaining pros. Things here are the cheapest in the Metro (you’ll get them at an even lower price the more you purchase and the better you haggle). Exploring the many streets of Divisoria will lead you to anything and everything, from affordable fabric to houseware and decor. Walk aimlessly around the streets of Soler, Tabora, Juan Luna, and Ilaya, keeping an eye out for the best bargains and deals. For a more organized shopping experience, venture into the 168 Mall, 999 Mall, and Tutuban Shopping Center for trendy RTW finds.","","","");
        mydb.insertDataInLandmarks("Bahay Tsino","The Bahay Tsinoy is a building in Intramuros, Manila, Philippines which houses the Kaisa-Angelo King Heritage Center, a museum documents the history, lives and contributions of the ethnic Chinese in the Philippine life and history. "," Location: 32 Anda St, Intramuros, Manila, 1002 Metro Manila "," Entrance Fee: Free "," Opening Hours: Tuesdays to Sundays 1pm to 5pm.");
        mydb.insertDataInLandmarks("Kartilya ng Katipunan","This shrine depicts one of Philippine history's greatest tragedies that Bonifacio became a victim of the very revolution he started, being assassinated by the men of Emilio Aguinaldo after the revolutionary forces split into two factions. The plaza in front is often used for different events, from political rallies to city fairs. Above it all stands the mighty Bonifacio, wielding his bolo and rallying his men to fight the better equipped Spaniards. "," Location: Ermita, Manila, 1000 Metro Manila ","","");
        mydb.insertDataInLandmarks("Malacañang Palace","It is one of the best places to visit in Manila for couples. Officially the residence of the President of Philippines, the Malacañang Palace does not often feature among the top tourist spots in Manila. Yet, it is an incredibly beautiful place steeped in history, and it is definitely among the best places to visit in Manila for fre. The Palace was built in the 18th century in the Bahay na Bato and Neoclassical style. The palace is well-maintained, and visitors can visit the Presidential Museum and Library for a better understanding of Manila since its independence. "," Location: Malacañan Palace, JP Laurel Street, San Miguel, Manila "," Entrance Fee: Free "," Opening Hours: Monday to Friday 8:00am - 5:00pm");
        mydb.insertDataInLandmarks("Casa Manila","This is a museum in the city of Intramuros that was built in the year 1980 by the architect, Imelda Marcos. The museum has been constructed in exquisite Spanish colonial architecture. This museum has been constructed as a replica to San Nicolas House that signified the colonia way of living of the Filipinos. There are awe-striking elements from the past that have been put on display here. If you’re a history buff, this place is a must visit. "," Location: Plaza San luis Complex, General Luna St, Intramuros, Manila, 1002 Metro Manila, Philippines "," Entrance Fee: P75.00 "," Opening Hours: Tuesday to Sunday 9:00am - 5:00pm ");
        mydb.insertDataInLandmarks("Money Museum","Tucked away inside the Philippine central banking authority, Banko Sentral ng Pilipinas, is a fascinating money museum. The galleries showcase Philippine money over several decades. There are artifacts, old coins, and various currencies on display that illustrate the changes in money over time. For the Philippine people, this collection represents economic stability in the country, but for visitors, it's a fun tourist attraction. "," Location: Bangko Sentral ng Pilipinas, A. Mabini St & P. Ocampo Street, Manila, Luzon "," Entrance Fee: Free "," Opening Hours: 9:00am - 12:00nn, 1:00pm - 4:00pm (Monday to Friday)");
        mydb.insertDataInLandmarks("Museo Pambata","Museo Pambata features hands-on exhibits that encourage children to explore and discover various concepts while they play. Museo Pambata is also active in producing educational workshops and events. "," Location: Roxas Boulevard cor. South Drive, Manila "," Entrance Fee: Children and Adults - Php 250.00 \n" +
                "Infants (under 2 years), museum workers, teachers (with valid ID) - FREE\n" +
                "Manila residents (with valid ID) - 50% discount\n "," Opening Hours: 8 AM to 5 PM (Tuesdays to Saturdays), 1 PM to 5 PM (Sundays). The museum is closed on Mondays and selected official holidays.");


        mydb.insertDataInRewards("FREE MCFLOAT AND FRIEST","CODE: @1203939");
        mydb.insertDataInRewards("FREE Girlfriend for 1 hour","CODE: @walang ganun tanga HAHAHA");
        mydb.insertDataInRewards("FREE GOSURF 50 at Globe","CODE: @212312");
        mydb.insertDataInRewards("FREE BigBite at 7-11","CODE: @111");
        mydb.insertDataInRewards("FREE Test me","CODE: @2");
        mydb.insertDataInRewards("FREE Test me","CODE: @4");
        mydb.insertDataInRewards("FREE Test me","CODE: @3");
    }

}