package tschausepp.model;

/**
 * enum which provides card colors
 * 
 * @author	Clarissa Sullivan
 * @since	2020-07-02
 * @version	1.0
 */
public enum CardColor {
	
	SCHAUFEL_CARD {
		@Override
		public int getSortingValue() {
			
			return 0;
		}
	},
	HERZ_CARD {
		@Override
		public int getSortingValue() {
			
			return 1;
		}
	},
	KREUZ_CARD {
		@Override
		public int getSortingValue() {
			
			return 2;
		}
	},
	ECKE_CARD {
		@Override
		public int getSortingValue() {
			
			return 3;
		}
	};
	
	public abstract int getSortingValue();
}