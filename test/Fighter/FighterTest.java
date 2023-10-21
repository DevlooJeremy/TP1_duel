package Fighter;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exception.AptitudesPointsUsedAbove100;
import Exception.AptitudesPointsUsedBelow0;
import FighterMock.FighterStub;
import Tools.Aptitudes;
import duel.Fighter;

class FighterTest {
	private static final int ANY_INTELLIGENCE = 20; 
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_FOCUS = 20;
	private static final int TOO_HIGH_STRENGHT = 100;
	public static final String ANY_NAME = "Jean";

	@Test
	void givenAFighter_whenCreatedWithMoreThenAHundredPoints_thenExceptionIsCalled() {
		Aptitudes apt = new Aptitudes(TOO_HIGH_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		
		assertThrows(AptitudesPointsUsedAbove100.class,()-> {
			Fighter fighter = new FighterStub(ANY_NAME,apt);
		});
	}
	
	@Test
	void gievenAFighter_whenCreated_fighterShouldSetAllHisAttributes() {
		//Arrange
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		//Act
		FighterStub fighter = new FighterStub(ANY_NAME,apt);
		int expectedHP = 200 - (ANY_STRENGHT + ANY_DEXTERITY + ANY_FOCUS +ANY_INTELLIGENCE);
		//Assert
		assertEquals(expectedHP,fighter.getHP());
		assertEquals(ANY_NAME,fighter.getName());
		assertEquals(ANY_STRENGHT,fighter.getStrenght());
		assertEquals(ANY_DEXTERITY,fighter.getDexterity());
		assertEquals(ANY_FOCUS,fighter.getFocus());
		assertEquals(ANY_INTELLIGENCE,fighter.getIntelligence());
	}
	
	

}
