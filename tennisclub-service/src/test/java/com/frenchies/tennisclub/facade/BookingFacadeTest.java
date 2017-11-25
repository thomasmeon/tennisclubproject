package com.frenchies.tennisclub.facade;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
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
//    private TeamFacade teamFacade;
//
//    private TeamCreateDTO teamCreateDTO;
//
//    private TeamDTO teamDTO;

    @BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void prepareTestTeam() {
        teamCreateDTO = new TeamCreateDTO();
        teamCreateDTO.setName("teamTestCreate");
        teamCreateDTO.setBudget(BigDecimal.valueOf(3000));
        teamCreateDTO.setCompetitionCountry(CompetitionCountry.CZECH_REPUBLIC);
        teamCreateDTO.setHumanPlayerId(1L);
        teamDTO = new TeamDTO();
        teamDTO.setName("teamTest");
    }

    @Test
    public void createTeamTest() {
        Long teamId = teamFacade.createTeam(teamCreateDTO);
        assertThat(teamFacade.getTeamById(teamId).getName()).isEqualTo(teamCreateDTO.getName());
        assertThat(teamFacade.getTeamById(teamId).getBudget()).isEqualTo(teamCreateDTO.getBudget());
        assertThat(teamFacade.getTeamById(teamId).getCompetitionCountry()).isEqualTo(teamCreateDTO.getCompetitionCountry());
    }

    @Test
    public void deleteTeamTest() {
        Long teamId = teamFacade.createTeam(teamCreateDTO);
        teamFacade.deleteTeam(teamId);
        assertThat(teamFacade.getTeamById(teamId)).isEqualTo(null);
    }

    @Test
    public void findAllTeamTeast(){
        Long teamId = teamFacade.createTeam(teamCreateDTO);
        List<TeamDTO> teams = teamFacade.getAllTeams();
        TeamDTO teamDTO = teamFacade.getTeamById(teamId);
        assertThat(teams).containsExactly(teamDTO);
    }

    @Test
    public void findByCompetitionCountryTeamTest(){
        Long teamId = teamFacade.createTeam(teamCreateDTO);
        List<TeamDTO> teams = teamFacade.getTeamsByCountry(CompetitionCountry.CZECH_REPUBLIC);
        TeamDTO teamDTO = teamFacade.getTeamById(teamId);
        assertThat(teams).containsExactly(teamDTO);
    }

    @Test
    public void addHockeyPlayerTeamTest(){
        // TODO
        Long teamId = teamFacade.createTeam(teamCreateDTO);
//        teamFacade.addHockyPlayer(teamId, hockeyPlayerId);
//        assertThat(teamFacade.getTeamById(teamId).getHockeyPlayers()).contains(hockeyPlayer)  ;
    }

    @Test
    public void removeHockeyPlayerTeamTest(){
        // TODO
        Long teamId = teamFacade.createTeam(teamCreateDTO);
//        teamFacade.addHockyPlayer(teamId, hockeyPlayerId);
//        assertThat(teamFacade.getTeamById(teamId).getHockeyPlayers()) contains(hockeyPlayer);
    }

    @Test
    public void spendMoneyFromBudgetTeamTest() throws TeamServiceException {
        Long teamId = teamFacade.createTeam(teamCreateDTO);
        teamFacade.spendMoneyFromBudget(teamId, BigDecimal.valueOf(300));
        assertThat(teamFacade.getTeamById(teamId).getBudget()).isEqualTo(BigDecimal.valueOf(2700));
    }

    @Test
    public void getTeamPriceTeamTest(){
        Long teamId = teamFacade.createTeam(teamCreateDTO);
        // TODO
        assertThat(teamFacade.getTeamPrice(teamId)).isEqualTo(BigDecimal.valueOf(30));
    }

    @Test
    public void getTeamAttackSkillTeamTest(){
        Long teamId = teamFacade.createTeam(teamCreateDTO);
        // TODO
        assertThat(teamFacade.getTeamAttackSkill(teamId)).isEqualTo(30);
    }


    @Test
    public void getTeamDefenseSkillTeamTest(){
        Long teamId = teamFacade.createTeam(teamCreateDTO);
        // TODO
        assertThat(teamFacade.getTeamDefenseSkill(teamId)).isEqualTo(30);
    }

    @Test
    public void findTeamByNameTeamTest(){
        Long teamId = teamFacade.createTeam(teamCreateDTO);
        assertThat(teamFacade.findTeamByName("teamTestCreate")).isEqualTo(teamDTO);
    }
}