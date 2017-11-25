package com.frenchies.tennisclub.facade;

import javax.transaction.Transactional;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.frenchies.tennisclub.service.config.ServiceConfiguration;

@ContextConfiguration(classes = ServiceConfiguration.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class BookingFacadeTest extends AbstractTestNGSpringContextTests {

//    @Autowired
//    private BookingFacade bookingFacade;
//
//    private BookingCreateDTO bookingCreateDTO;
//
//    private BookingDTO bookingDTO;
//
//    @BeforeClass
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @BeforeMethod
//    public void prepareTestTeam() {
//    	Calendar cal = Calendar.getInstance();
//		cal.set(2017, 1, 1);
//		Date date1 = cal.getTime();
//		
//        bookingCreateDTO = new BookingCreateDTO();
//        bookingCreateDTO.setIdCourt((long) 1);
//        bookingCreateDTO.setDateOfBooking(date1);
//        bookingCreateDTO.setHourOfBooking(Hour24.EIGHT);
//        
//        bookingDTO = new BookingDTO();
//        bookingDTO.setDateOfBooking(date1);
//    }
//
//    @Test
//    public void createTeamTest() {
//        Long bookingId = bookingFacade.createBooking(bookingCreateDTO);
//        assertThat(bookingFacade.getTeamById(teamId).getName()).isEqualTo(bookingCreateDTO.getName());
//        assertThat(bookingFacade.getTeamById(teamId).getBudget()).isEqualTo(bookingCreateDTO.getBudget());
//        assertThat(bookingFacade.getTeamById(teamId).getCompetitionCountry()).isEqualTo(bookingCreateDTO.getCompetitionCountry());
//    }
//
//    @Test
//    public void deleteTeamTest() {
//        Long teamId = bookingFacade.createTeam(bookingCreateDTO);
//        bookingFacade.deleteTeam(teamId);
//        assertThat(bookingFacade.getTeamById(teamId)).isEqualTo(null);
//    }
//
//    @Test
//    public void findAllTeamTeast(){
//        Long teamId = bookingFacade.createTeam(bookingCreateDTO);
//        List<TeamDTO> teams = bookingFacade.getAllTeams();
//        TeamDTO teamDTO = bookingFacade.getTeamById(teamId);
//        assertThat(teams).containsExactly(teamDTO);
//    }
//
//    @Test
//    public void findByCompetitionCountryTeamTest(){
//        Long teamId = bookingFacade.createTeam(bookingCreateDTO);
//        List<TeamDTO> teams = bookingFacade.getTeamsByCountry(CompetitionCountry.CZECH_REPUBLIC);
//        TeamDTO teamDTO = bookingFacade.getTeamById(teamId);
//        assertThat(teams).containsExactly(teamDTO);
//    }
//
//    @Test
//    public void addHockeyPlayerTeamTest(){
//        // TODO
//        Long teamId = bookingFacade.createTeam(bookingCreateDTO);
////        teamFacade.addHockyPlayer(teamId, hockeyPlayerId);
////        assertThat(teamFacade.getTeamById(teamId).getHockeyPlayers()).contains(hockeyPlayer)  ;
//    }
//
//    @Test
//    public void removeHockeyPlayerTeamTest(){
//        // TODO
//        Long teamId = bookingFacade.createTeam(bookingCreateDTO);
////        teamFacade.addHockyPlayer(teamId, hockeyPlayerId);
////        assertThat(teamFacade.getTeamById(teamId).getHockeyPlayers()) contains(hockeyPlayer);
//    }
//
//    @Test
//    public void spendMoneyFromBudgetTeamTest() throws TeamServiceException {
//        Long teamId = bookingFacade.createTeam(bookingCreateDTO);
//        bookingFacade.spendMoneyFromBudget(teamId, BigDecimal.valueOf(300));
//        assertThat(bookingFacade.getTeamById(teamId).getBudget()).isEqualTo(BigDecimal.valueOf(2700));
//    }
//
//    @Test
//    public void getTeamPriceTeamTest(){
//        Long teamId = bookingFacade.createTeam(bookingCreateDTO);
//        // TODO
//        assertThat(bookingFacade.getTeamPrice(teamId)).isEqualTo(BigDecimal.valueOf(30));
//    }
//
//    @Test
//    public void getTeamAttackSkillTeamTest(){
//        Long teamId = bookingFacade.createTeam(bookingCreateDTO);
//        // TODO
//        assertThat(bookingFacade.getTeamAttackSkill(teamId)).isEqualTo(30);
//    }
//
//
//    @Test
//    public void getTeamDefenseSkillTeamTest(){
//        Long teamId = bookingFacade.createTeam(bookingCreateDTO);
//        // TODO
//        assertThat(bookingFacade.getTeamDefenseSkill(teamId)).isEqualTo(30);
//    }
//
//    @Test
//    public void findTeamByNameTeamTest(){
//        Long teamId = bookingFacade.createTeam(bookingCreateDTO);
//        assertThat(bookingFacade.findTeamByName("teamTestCreate")).isEqualTo(bookingDTO);
//    }
}