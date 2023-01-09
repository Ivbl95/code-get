export interface CodeGetPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
