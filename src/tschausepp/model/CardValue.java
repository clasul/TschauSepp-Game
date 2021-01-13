package tschausepp.model;

/**
 * enum which provides card values
 * 
 * @author	Clarissa Sullivan
 * @since	2020-06-29
 * @version	1.0
 */
public enum CardValue {
	
	NUM_10 {
		@Override
		public int getSortingValue() {
			
			return 10;
		}
	},
	NUM_9 {
		@Override
		public int getSortingValue() {
			
			return 9;
		}
	},
	NUM_8 {
		@Override
		public int getSortingValue() {
			
			return 8;
		}
	},
	NUM_7 {
		@Override
		public int getSortingValue() {
			
			return 7;
		}
	},
	NUM_6 {
		@Override
		public int getSortingValue() {
			
			return 6;
		}
	},
	NUM_BUBE {
		@Override
		public int getSortingValue() {
			
			return 5;
		}
	},
	NUM_DAME {
		@Override
		public int getSortingValue() {
			
			return 4;
		}
	},
	NUM_KOENIG {
		@Override
		public int getSortingValue() {
			
			return 3;
		}
	},
	NUM_ASS {
		@Override
		public int getSortingValue() {
			
			return 2;
		}
	};
	
	public abstract int getSortingValue();
}