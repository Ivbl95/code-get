import { WebPlugin } from '@capacitor/core';

import type { CodeGetPlugin } from './definitions';

export class CodeGetWeb extends WebPlugin implements CodeGetPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
