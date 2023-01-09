import { registerPlugin } from '@capacitor/core';

import type { CodeGetPlugin } from './definitions';

const CodeGet = registerPlugin<CodeGetPlugin>('CodeGet', {
  web: () => import('./web').then(m => new m.CodeGetWeb()),
});

export * from './definitions';
export { CodeGet };
